package com.example.Banco.Saint.Patrick.Auth.Service;

import com.example.Banco.Saint.Patrick.Auth.AuthResponse;
import com.example.Banco.Saint.Patrick.Auth.LoginRequest;
import com.example.Banco.Saint.Patrick.Model.Usuario;
import com.example.Banco.Saint.Patrick.Repository.UsuarioRepository;
import com.example.Banco.Saint.Patrick.Security.JWTUtil;
import com.example.Banco.Saint.Patrick.Security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;  //Para buscar el usuario
    private final JWTUtil jwtUtil;  //Para generar el token
    private final PasswordEncoder passwordEncoder; //Encriptar el TOKEN



    @Autowired
    private final AuthenticationManager authenticationManager; // Para que se autentique
    public AuthResponse login(LoginRequest loginRequest) {

        try {

            System.out.println("Auth Service: --->  username: " + loginRequest.getUsername() +"  Pin:  "+ loginRequest.getPin());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPin()));

        }catch (AuthenticationException ex) {
            throw new RuntimeException("PIN o usuario incorrecto");

    }
        System.out.println("Login: -->  Username:  " + loginRequest.getUsername() +"  Pin:  " + loginRequest.getPin());
        Usuario usuario = usuarioRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        System.out.println("Usuario buscado en el repositorio: --->  " + usuario);
        String token = jwtUtil.generateToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();
}}
