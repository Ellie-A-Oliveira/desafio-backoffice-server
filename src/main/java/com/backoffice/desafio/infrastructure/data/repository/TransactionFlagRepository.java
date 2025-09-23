package com.backoffice.desafio.infrastructure.data.repository;

import com.backoffice.desafio.domain.entity.TransactionFlag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionFlagRepository extends JpaRepository<TransactionFlag, UUID> {
}
