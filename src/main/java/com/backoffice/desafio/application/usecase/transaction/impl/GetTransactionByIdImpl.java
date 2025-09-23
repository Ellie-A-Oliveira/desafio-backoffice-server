package com.backoffice.desafio.application.usecase.transaction.impl;

import com.backoffice.desafio.application.usecase.transaction.GetTransactionById;
import com.backoffice.desafio.domain.entity.Transaction;
import com.backoffice.desafio.infrastructure.data.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTransactionByIdImpl implements GetTransactionById {
    private final TransactionRepository transactionRepository;

    @Override
    public Optional<Transaction> execute(UUID id) {
        return transactionRepository.findById(id);
    }
}
