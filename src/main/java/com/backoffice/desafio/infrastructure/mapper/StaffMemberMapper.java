package com.backoffice.desafio.infrastructure.mapper;

import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.presentation.gateway.dto.request.CreateStaffMemberRequest;
import com.backoffice.desafio.presentation.gateway.dto.response.GetStaffMemberResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMemberMapper {
    StaffMember createStaffMemberRequestToStaffMember(CreateStaffMemberRequest dto);
    GetStaffMemberResponse staffMemberToGetStaffMemberResponse(StaffMember entity);
    List<GetStaffMemberResponse> staffMembersToGetStaffMemberResponses(List<StaffMember> entities);
}
