package com.backoffice.desafio.application.usecase.staffmember.impl;

import com.backoffice.desafio.application.usecase.staffmember.GetSystemStaffMember;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.enumerator.StaffRole;
import com.backoffice.desafio.infrastructure.data.repository.StaffMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSystemStaffMemberImpl implements GetSystemStaffMember {
    private final StaffMemberRepository staffMemberRepository;
    @Override
    public StaffMember execute() {
        return staffMemberRepository.findFirstByRole(StaffRole.SYSTEM);
    }
}
