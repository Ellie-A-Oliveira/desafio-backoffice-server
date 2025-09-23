package com.backoffice.desafio.domain.entity;

import com.backoffice.desafio.domain.enumerator.TransactionFlagSeverity;
import com.backoffice.desafio.domain.enumerator.TransactionFlagStatus;
import com.backoffice.desafio.domain.enumerator.TransactionFlagType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Builder
public class TransactionFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID flagId;

    private TransactionFlagType flagType;
    private String reason;
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    private TransactionFlagSeverity severity;

    @Enumerated(EnumType.STRING)
    private TransactionFlagStatus status;

    @ManyToOne
    private Transaction transaction;

    @ManyToOne
    private StaffMember createdBy;
}
