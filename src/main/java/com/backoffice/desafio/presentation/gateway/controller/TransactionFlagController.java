package com.backoffice.desafio.presentation.gateway.controller;

import com.backoffice.desafio.application.usecase.transactionflag.GetAllTransactionFlags;
import com.backoffice.desafio.domain.entity.TransactionFlag;
import com.backoffice.desafio.infrastructure.mapper.TransactionFlagMapper;
import com.backoffice.desafio.presentation.gateway.dto.response.GetTransactionFlagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction-flag")
@RequiredArgsConstructor
public class TransactionFlagController {
    private final TransactionFlagMapper transactionFlagMapper;

    // Use cases
    private final GetAllTransactionFlags getAllTransactionFlags;

    @GetMapping
    public ResponseEntity<List<GetTransactionFlagResponse>> getAll() {
        List<TransactionFlag> flags = getAllTransactionFlags.execute();
        List<GetTransactionFlagResponse> response = transactionFlagMapper.transactionFlagsToGetTransactionFlagResponses(flags);
        return ResponseEntity.ok(response);
    }
}
