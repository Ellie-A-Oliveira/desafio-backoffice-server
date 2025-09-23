package com.backoffice.desafio.infrastructure.data;

import com.backoffice.desafio.domain.Case;
import com.backoffice.desafio.domain.StaffActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffActionLogRepository extends JpaRepository<StaffActionLog, UUID> {
}
