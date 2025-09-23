package com.backoffice.desafio.presentation.gateway.dto.response;

import com.backoffice.desafio.domain.enumerator.StaffRole;
import com.backoffice.desafio.domain.enumerator.StaffStatus;

import java.util.UUID;

public record GetStaffMemberResponse(
        UUID staffId,
        String fullName,
        String email,
        StaffRole role,
        StaffStatus status
) { }
