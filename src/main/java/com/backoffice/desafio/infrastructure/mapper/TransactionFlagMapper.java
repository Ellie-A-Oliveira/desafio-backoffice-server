package com.backoffice.desafio.infrastructure.mapper;

import com.backoffice.desafio.domain.entity.Transaction;
import com.backoffice.desafio.domain.entity.TransactionFlag;
import com.backoffice.desafio.presentation.gateway.dto.response.GetTransactionFlagResponse;
import com.backoffice.desafio.presentation.gateway.dto.response.GetTransactionResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionFlagMapper {
    @Mapping(target = "transactionId", source="transaction.transactionId")
    List<GetTransactionFlagResponse> transactionFlagsToGetTransactionFlagResponses(List<TransactionFlag> entities);
}
