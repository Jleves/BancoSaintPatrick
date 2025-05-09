package com.example.Banco.Saint.Patrick.Security;
import com.example.Banco.Saint.Patrick.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;





@Configuration
public class SecurityConfig {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private JwrRequestFilter jwtRequestFilter;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



 //Dao Authenticador provider

 @Bean
 public DaoAuthenticationProvider daoAuthenticationProvider(){
 DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
 provider.setPasswordEncoder(bCryptPasswordEncoder);
 provider.setUserDetailsService(usuarioService);
 return provider;
 }






 @Bean
 public CorsConfigurationSource corsConfigurationSource(){
 CorsConfiguration configuration = new CorsConfiguration();
 configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173",""));
 configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT","OPTIONS"));
 configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
 configuration.setAllowCredentials(true);
 UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
 source.registerCorsConfiguration("/**",configuration);
 return source;
 }





 @Bean
 public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
 {
 return config.getAuthenticationManager();
 }

 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 auth.authenticationProvider(daoAuthenticationProvider());
 }




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 🔓 Desactiva CSRF (necesario para POST desde Postman)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/Transaccion/newTransfer").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.GET,"/usuarios/*").hasAnyRole("USER")
                        .anyRequest().authenticated() // ✅ Requiere autenticación para todo
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}