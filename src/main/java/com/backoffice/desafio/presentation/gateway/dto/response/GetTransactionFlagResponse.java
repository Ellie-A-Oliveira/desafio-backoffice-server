package com.backoffice.desafio.presentation.gateway.dto.response;

import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.enumerator.TransactionFlagSeverity;
import com.backoffice.desafio.domain.enumerator.TransactionFlagStatus;
import com.backoffice.desafio.domain.enumerator.TransactionFlagType;

import java.time.Instant;
import java.util.UUID;

public record GetTransactionFlagResponse(
        UUID flagId,
        TransactionFlagType flagType,
        String reason,
        Instant createdAt,
        TransactionFlagSeverity severity,
        TransactionFlagStatus status,
        UUID transactionId,
        StaffMember createdBy
) {
}
