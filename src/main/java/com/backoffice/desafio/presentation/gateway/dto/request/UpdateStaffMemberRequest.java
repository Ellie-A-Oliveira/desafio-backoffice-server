package com.backoffice.desafio.presentation.gateway.dto.request;

import com.backoffice.desafio.domain.enumerator.StaffRole;

public record UpdateStaffMemberRequest(
        String fullName,
        String email,
        StaffRole role
) { }
