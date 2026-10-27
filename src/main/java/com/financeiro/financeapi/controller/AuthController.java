package com.financeiro.financeapi.controller;

import com.financeiro.financeapi.dto.LoginRequestDTO;
import com.financeiro.financeapi.dto.RegisterRequestDTO;
import com.financeiro.financeapi.dto.TokenResponseDTO;
import com.financeiro.financeapi.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> register(@RequestBody @Valid RegisterRequestDTO dto) {
        TokenResponseDTO response = authService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        TokenResponseDTO response = authService.login(dto);
        return ResponseEntity.ok(response);
    }
}