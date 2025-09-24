package com.backoffice.desafio.application.usecase.transactionflag.impl;

import com.backoffice.desafio.application.usecase.transactionflag.GetAllTransactionFlags;
import com.backoffice.desafio.domain.entity.TransactionFlag;
import com.backoffice.desafio.infrastructure.data.repository.TransactionFlagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTransactionFlagsImpl implements GetAllTransactionFlags {
    private final TransactionFlagRepository transactionFlagRepository;

    @Override
    public List<TransactionFlag> execute() {
        return transactionFlagRepository.findAll();
    }
}
