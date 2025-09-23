package com.backoffice.desafio.application.usecase.staffmember.impl;

import com.backoffice.desafio.application.usecase.staffmember.CreateStaffMember;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.infrastructure.data.repository.StaffMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStaffMemberImpl implements CreateStaffMember {
    private final StaffMemberRepository staffMemberRepository;

    @Override
    public StaffMember execute(StaffMember staffMemberToBeCreated) {
        return staffMemberRepository.save(staffMemberToBeCreated);
    }
}
