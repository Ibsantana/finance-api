package com.financeiro.financeapi.controller;

import com.financeiro.financeapi.dto.TransactionRequestDTO;
import com.financeiro.financeapi.dto.TransactionResponseDTO;
import com.financeiro.financeapi.model.User;
import com.financeiro.financeapi.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> create(
            @Valid @RequestBody TransactionRequestDTO dto,
            @AuthenticationPrincipal User user) {
        TransactionResponseDTO created = transactionService.create(dto, user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<Page<TransactionResponseDTO>> findAll(
            @AuthenticationPrincipal User user,
            @PageableDefault(size = 10, sort = "date") Pageable pageable) {
        Page<TransactionResponseDTO> transactions = transactionService.findAllByUserId(user.getId(), pageable);
        return ResponseEntity.ok(transactions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}