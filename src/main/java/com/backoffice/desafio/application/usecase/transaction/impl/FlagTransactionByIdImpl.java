package com.backoffice.desafio.application.usecase.transaction.impl;

import com.backoffice.desafio.application.usecase.transaction.FlagTransactionById;
import com.backoffice.desafio.application.usecase.transactionflag.CreateTransactionFlag;
import com.backoffice.desafio.domain.entity.Transaction;
import com.backoffice.desafio.domain.entity.TransactionFlag;
import com.backoffice.desafio.domain.enumerator.TransactionFlagType;
import com.backoffice.desafio.domain.exception.StaffMemberNotFoundException;
import com.backoffice.desafio.domain.exception.TransactionNotFoundException;
import com.backoffice.desafio.infrastructure.data.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlagTransactionByIdImpl implements FlagTransactionById {
    private final TransactionRepository transactionRepository;
    private final CreateTransactionFlag createTransactionFlag;

    @Override
    public UUID execute(UUID id, TransactionFlagType type, String reason) {
        Transaction transactionToFlag = transactionRepository.findById(id)
                .orElseThrow(() ->
                        new TransactionNotFoundException("Transaction with ID " + id + " not found."));

        TransactionFlag createdTransactionFlag = createTransactionFlag.execute(transactionToFlag, type, reason);

        return createdTransactionFlag.getFlagId();
    }
}
