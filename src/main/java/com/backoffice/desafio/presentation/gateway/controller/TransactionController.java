package com.backoffice.desafio.presentation.gateway.controller;

import com.backoffice.desafio.application.usecase.transaction.FlagTransactionById;
import com.backoffice.desafio.application.usecase.transaction.GetAllTransaction;
import com.backoffice.desafio.application.usecase.transaction.GetTransactionById;
import com.backoffice.desafio.application.usecase.transactionflag.CreateTransactionFlag;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.entity.Transaction;
import com.backoffice.desafio.domain.exception.TransactionNotFoundException;
import com.backoffice.desafio.infrastructure.mapper.TransactionMapper;
import com.backoffice.desafio.presentation.gateway.dto.request.CreateStaffMemberRequest;
import com.backoffice.desafio.presentation.gateway.dto.request.CreateTransactionFlagRequest;
import com.backoffice.desafio.presentation.gateway.dto.response.GetTransactionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionMapper transactionMapper;

    // Use cases
    private final GetAllTransaction getAllTransaction;
    private final GetTransactionById getTransactionById;
    private final FlagTransactionById flagTransactionById;

    @GetMapping
    public ResponseEntity<List<GetTransactionResponse>> getAll() {
        List<Transaction> allTransactions = getAllTransaction.execute();

        List<GetTransactionResponse> response = transactionMapper.transactionsToGetTransactionResponses(allTransactions);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetTransactionResponse> getById(@PathVariable UUID id) {
        Optional<Transaction> foundTransaction = getTransactionById.execute(id);

        if (foundTransaction.isEmpty()) return ResponseEntity.notFound().build();

        GetTransactionResponse response = transactionMapper.transactionToGetTransactionResponse(foundTransaction.get());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/flag")
    public ResponseEntity<UUID> flagTransactionById(
            @PathVariable UUID id,
            @RequestBody @Valid CreateTransactionFlagRequest request)
            throws BadRequestException {
        try {
            UUID flagId = flagTransactionById.execute(id, request.type(), request.reason());
            return ResponseEntity.ok(flagId);
        } catch (TransactionNotFoundException e) {
            throw new BadRequestException(e);
        }
    }
}
