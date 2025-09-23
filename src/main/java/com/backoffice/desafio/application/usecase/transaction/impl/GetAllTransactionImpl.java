package com.backoffice.desafio.application.usecase.transaction.impl;

import com.backoffice.desafio.application.usecase.transaction.GetAllTransaction;
import com.backoffice.desafio.domain.entity.Transaction;
import com.backoffice.desafio.infrastructure.data.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTransactionImpl implements GetAllTransaction {
    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> execute() {
        return transactionRepository.findAll();
    }
}
