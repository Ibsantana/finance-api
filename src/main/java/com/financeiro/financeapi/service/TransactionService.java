package com.financeiro.financeapi.service;

import com.financeiro.financeapi.dto.TransactionRequestDTO;
import com.financeiro.financeapi.dto.TransactionResponseDTO;
import com.financeiro.financeapi.exception.ResourceNotFoundException;
import com.financeiro.financeapi.model.Category;
import com.financeiro.financeapi.model.Transaction;
import com.financeiro.financeapi.model.User;
import com.financeiro.financeapi.repository.CategoryRepository;
import com.financeiro.financeapi.repository.TransactionRepository;
import com.financeiro.financeapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public TransactionResponseDTO create(TransactionRequestDTO dto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador não encontrado"));

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        Transaction transaction = Transaction.builder()
                .description(dto.description())
                .amount(dto.amount())
                .date(dto.date())
                .type(dto.type())
                .category(category)
                .user(user)
                .build();

        Transaction saved = transactionRepository.save(transaction);
        return mapToDTO(saved);
    }

    public Page<TransactionResponseDTO> findAllByUserId(Long userId, Pageable pageable) {
        return transactionRepository.findByUserId(userId, pageable)
                .map(this::mapToDTO);
    }

    private TransactionResponseDTO mapToDTO(Transaction t) {
        return new TransactionResponseDTO(
                t.getId(),
                t.getDescription(),
                t.getAmount(),
                t.getDate(),
                t.getType(),
                t.getCategory().getName()
        );
    }

    public void deleteById(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new RuntimeException("Transação não encontrada com o ID: " + id);
        }
        transactionRepository.deleteById(id);
    }

}
