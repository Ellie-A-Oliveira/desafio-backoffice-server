package com.backoffice.desafio.application.usecase.transaction;

import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetAllTransaction {
    List<Transaction> execute();
}
