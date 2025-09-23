package com.backoffice.desafio.application.usecase.staffmember.impl;

import com.backoffice.desafio.application.usecase.staffmember.GetStaffMemberById;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.infrastructure.data.repository.StaffMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetStaffMemberByIdImpl implements GetStaffMemberById {
    private final StaffMemberRepository staffMemberRepository;

    @Override
    public Optional<StaffMember> execute(UUID id) {
        return staffMemberRepository.findById(id);
    }
}
