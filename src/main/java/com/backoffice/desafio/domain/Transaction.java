package com.backoffice.desafio.domain;

import com.backoffice.desafio.domain.enumerator.TransactionChannel;
import com.backoffice.desafio.domain.enumerator.TransactionStatus;
import com.backoffice.desafio.domain.enumerator.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;

    private UUID accountId; // Assumes link with another microservice
    private UUID customerId; // Assumes link with another microservice
    private BigDecimal amount;
    private String currency;
    private Instant timestamp;
    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    private TransactionChannel channel;

    @OneToMany
    private List<TransactionFlag> transactionFlags;

    @OneToMany
    private List<Case> cases;
}
