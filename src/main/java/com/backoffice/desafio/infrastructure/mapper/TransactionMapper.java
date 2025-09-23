package com.backoffice.desafio.infrastructure.mapper;

import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.entity.Transaction;
import com.backoffice.desafio.presentation.gateway.dto.response.GetStaffMemberResponse;
import com.backoffice.desafio.presentation.gateway.dto.response.GetTransactionResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    GetTransactionResponse transactionToGetTransactionResponse(Transaction entity);
    List<GetTransactionResponse> transactionsToGetTransactionResponses(List<Transaction> entities);
}
