package com.backoffice.desafio.application.usecase.transaction;

import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface GetTransactionById {
    Optional<Transaction> execute(UUID id);
}
