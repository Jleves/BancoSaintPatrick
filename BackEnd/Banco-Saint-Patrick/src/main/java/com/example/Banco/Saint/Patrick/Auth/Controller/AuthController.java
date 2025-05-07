package com.example.Banco.Saint.Patrick.Auth.Controller;

import com.example.Banco.Saint.Patrick.Auth.AuthResponse;
import com.example.Banco.Saint.Patrick.Auth.LoginRequest;
import com.example.Banco.Saint.Patrick.Auth.Service.AuthService;
import com.example.Banco.Saint.Patrick.Security.JWTUtil;
import com.example.Banco.Saint.Patrick.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UsuarioService usuarioService;
    private final JWTUtil jwtUtil;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){

        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
