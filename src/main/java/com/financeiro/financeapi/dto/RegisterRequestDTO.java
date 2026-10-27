package com.financeiro.financeapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}