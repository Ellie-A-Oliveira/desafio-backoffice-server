package com.backoffice.desafio.application.usecase.staffmember.impl;

import com.backoffice.desafio.application.usecase.staffmember.DeleteStaffMember;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.exception.StaffMemberNotFoundException;
import com.backoffice.desafio.infrastructure.data.repository.StaffMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteStaffMemberImpl implements DeleteStaffMember {
    private final StaffMemberRepository staffMemberRepository;

    @Override
    public UUID execute(UUID id) {
        StaffMember staffMember = staffMemberRepository.findById(id)
                .orElseThrow(() ->
                        new StaffMemberNotFoundException("Staff member with ID " + id + " not found."));

        staffMemberRepository.delete(staffMember);

        return id;
    }
}
