package com.financeiro.financeapi.service;

import com.financeiro.financeapi.dto.LoginRequestDTO;
import com.financeiro.financeapi.dto.RegisterRequestDTO;
import com.financeiro.financeapi.dto.TokenResponseDTO;
import com.financeiro.financeapi.model.User;
import com.financeiro.financeapi.repository.UserRepository;
import com.financeiro.financeapi.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public TokenResponseDTO register(RegisterRequestDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user);

        String token = tokenService.generateToken(user);
        return new TokenResponseDTO(token);
    }

    public TokenResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        String token = tokenService.generateToken(user);
        return new TokenResponseDTO(token);
    }
}