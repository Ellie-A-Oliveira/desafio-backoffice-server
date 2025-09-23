package com.backoffice.desafio.application.usecase.transactionflag.impl;

import com.backoffice.desafio.application.usecase.staffmember.GetSystemStaffMember;
import com.backoffice.desafio.application.usecase.transactionflag.CreateTransactionFlag;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.entity.Transaction;
import com.backoffice.desafio.domain.entity.TransactionFlag;
import com.backoffice.desafio.domain.enumerator.TransactionFlagType;
import com.backoffice.desafio.infrastructure.data.repository.TransactionFlagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CreateTransactionFlagImpl implements CreateTransactionFlag {
    private final TransactionFlagRepository transactionFlagRepository;
    private final GetSystemStaffMember getSystemStaffMember;

    @Override
    public TransactionFlag execute(Transaction transaction, TransactionFlagType type, String reason) {
        StaffMember system = getSystemStaffMember.execute();

        TransactionFlag transactionFlagToBeCreated = TransactionFlag
                .builder()
                .transaction(transaction)
                .flagType(type)
                .reason(reason)
                .createdAt(Instant.now())
                .createdBy(system)
                .build();

        return transactionFlagRepository.save(transactionFlagToBeCreated);
    }
}
