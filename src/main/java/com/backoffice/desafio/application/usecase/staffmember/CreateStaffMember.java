package com.backoffice.desafio.application.usecase.staffmember;

import com.backoffice.desafio.domain.entity.StaffMember;
import org.springframework.stereotype.Service;

@Service
public interface CreateStaffMember {
    StaffMember execute(StaffMember staffMemberToBeCreated);
}
