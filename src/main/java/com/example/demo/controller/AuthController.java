package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.LoginForm;
import com.example.demo.security.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginForm.getUsername());

        if (userDetails != null && passwordEncoder.matches(loginForm.getPassword(), userDetails.getPassword())) {
            // Credenciais válidas, usuário autenticado com sucesso
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            // Credenciais inválidas, retorna uma resposta de erro
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}
