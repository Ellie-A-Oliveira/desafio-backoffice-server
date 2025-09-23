package com.backoffice.desafio.application.usecase.staffmember;

import com.backoffice.desafio.domain.entity.StaffMember;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface GetStaffMemberById {
    Optional<StaffMember> execute(UUID id);
}
