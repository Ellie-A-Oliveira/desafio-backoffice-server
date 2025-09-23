package com.backoffice.desafio.infrastructure.data;

import com.backoffice.desafio.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
