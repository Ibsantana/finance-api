package com.financeiro.financeapi.dto;

import com.financeiro.financeapi.model.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequestDTO(
        @NotBlank(message = "A descrição é obrigatória")
        String description,

        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser maior que zero")
        BigDecimal amount,

        @NotNull(message = "A data é obrigatória")
        LocalDate date,

        @NotNull(message = "O tipo é obrigatório (RECEITA ou DESPESA)")
        TransactionType type,

        @NotNull(message = "O ID da categoria é obrigatório")
        Long categoryId
) {}