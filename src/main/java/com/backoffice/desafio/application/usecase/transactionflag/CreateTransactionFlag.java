package com.backoffice.desafio.application.usecase.transactionflag;

import com.backoffice.desafio.domain.entity.Transaction;
import com.backoffice.desafio.domain.entity.TransactionFlag;
import com.backoffice.desafio.domain.enumerator.TransactionFlagType;
import org.springframework.stereotype.Service;

@Service
public interface CreateTransactionFlag {
    TransactionFlag execute(Transaction transaction, TransactionFlagType type, String reason);
}
