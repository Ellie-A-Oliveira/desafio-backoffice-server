package com.backoffice.desafio.application.usecase.transaction;

import com.backoffice.desafio.domain.entity.TransactionFlag;
import com.backoffice.desafio.domain.enumerator.TransactionFlagType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface FlagTransactionById {
    UUID execute(UUID id, TransactionFlagType type, String reason);
}
