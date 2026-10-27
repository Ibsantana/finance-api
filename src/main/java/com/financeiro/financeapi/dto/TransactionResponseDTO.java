package com.financeiro.financeapi.dto;

import com.financeiro.financeapi.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        LocalDate date,
        TransactionType type,
        String categoryName
) {}