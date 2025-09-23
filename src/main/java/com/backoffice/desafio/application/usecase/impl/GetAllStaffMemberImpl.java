package com.backoffice.desafio.application.usecase.impl;

import com.backoffice.desafio.application.usecase.GetAllStaffMember;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.infrastructure.data.repository.StaffMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllStaffMemberImpl implements GetAllStaffMember {
    private final StaffMemberRepository staffMemberRepository;

    @Override
    public List<StaffMember> execute() {
        return staffMemberRepository.findAll();
    }
}
