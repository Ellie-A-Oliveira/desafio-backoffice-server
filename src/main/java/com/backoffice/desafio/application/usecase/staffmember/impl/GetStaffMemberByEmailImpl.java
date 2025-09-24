package com.backoffice.desafio.application.usecase.staffmember.impl;

import com.backoffice.desafio.application.usecase.staffmember.GetStaffMemberByEmail;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.infrastructure.data.repository.StaffMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStaffMemberByEmailImpl implements GetStaffMemberByEmail {
    private final StaffMemberRepository staffMemberRepository;
    @Override
    public StaffMember execute(String email) {
        return staffMemberRepository.findByEmail(email);
    }
}
