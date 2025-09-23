package com.backoffice.desafio.infrastructure.data;

import com.backoffice.desafio.domain.TransactionFlag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionFlagRepository extends JpaRepository<TransactionFlag, UUID> {
}
