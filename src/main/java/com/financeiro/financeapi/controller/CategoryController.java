package com.financeiro.financeapi.controller;

import com.financeiro.financeapi.dto.CategoryRequestDTO;
import com.financeiro.financeapi.dto.CategoryResponseDTO;
import com.financeiro.financeapi.model.User;
import com.financeiro.financeapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(
            @Valid @RequestBody CategoryRequestDTO dto,
            @AuthenticationPrincipal User user) {
        CategoryResponseDTO created = categoryService.create(dto, user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAll(
            @AuthenticationPrincipal User user) {
        List<CategoryResponseDTO> categories = categoryService.findAllByUserId(user.getId());
        return ResponseEntity.ok(categories);
    }
}