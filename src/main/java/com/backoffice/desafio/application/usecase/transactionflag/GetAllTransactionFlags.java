package com.backoffice.desafio.application.usecase.transactionflag;

import com.backoffice.desafio.domain.entity.TransactionFlag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetAllTransactionFlags {
    List<TransactionFlag> execute();
}
