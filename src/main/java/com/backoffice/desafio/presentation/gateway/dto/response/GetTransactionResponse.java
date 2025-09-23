package com.backoffice.desafio.presentation.gateway.dto.response;

import com.backoffice.desafio.domain.enumerator.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record GetTransactionResponse(
        UUID transactionId,
        UUID accountId,
        UUID customerId,
        BigDecimal amount,
        String currency,
        Instant timestamp,
        String description,
        TransactionType transactionType,
        TransactionStatus status,
        TransactionChannel channel
) { }
