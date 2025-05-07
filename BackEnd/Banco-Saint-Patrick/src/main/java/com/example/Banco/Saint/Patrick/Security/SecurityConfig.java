package com.example.Banco.Saint.Patrick.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 🔓 Desactiva CSRF (necesario para POST desde Postman)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // ✅ Requiere autenticación para todo
                )
                .httpBasic(Customizer.withDefaults()); // 🔑 Habilita autenticación básica

        return http.build();
    }
}