package com.backoffice.desafio.infrastructure.data.repository;

import com.backoffice.desafio.domain.entity.StaffActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffActionLogRepository extends JpaRepository<StaffActionLog, UUID> {
}
