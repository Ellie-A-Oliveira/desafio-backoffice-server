package com.backoffice.desafio.presentation.gateway.dto.request;

import com.backoffice.desafio.domain.enumerator.TransactionFlagType;

public record CreateTransactionFlagRequest(
        TransactionFlagType type,
        String reason
) {
}
