package com.financeiro.financeapi.service;

import com.financeiro.financeapi.dto.CategoryRequestDTO;
import com.financeiro.financeapi.dto.CategoryResponseDTO;
import com.financeiro.financeapi.exception.ResourceNotFoundException;
import com.financeiro.financeapi.model.Category;
import com.financeiro.financeapi.model.User;
import com.financeiro.financeapi.repository.CategoryRepository;
import com.financeiro.financeapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CategoryResponseDTO create(CategoryRequestDTO dto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador não encontrado"));

        Category category = Category.builder()
                .name(dto.name())
                .user(user)
                .build();

        Category saved = categoryRepository.save(category);
        return new CategoryResponseDTO(saved.getId(), saved.getName());
    }

    public List<CategoryResponseDTO> findAllByUserId(Long userId) {
        return categoryRepository.findByUserId(userId)
                .stream()
                .map(c -> new CategoryResponseDTO(c.getId(), c.getName()))
                .toList();
    }
}