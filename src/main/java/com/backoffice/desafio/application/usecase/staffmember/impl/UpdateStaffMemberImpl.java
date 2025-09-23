package com.backoffice.desafio.application.usecase.staffmember.impl;

import com.backoffice.desafio.application.usecase.staffmember.UpdateStaffMember;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.exception.StaffMemberNotFoundException;
import com.backoffice.desafio.infrastructure.data.repository.StaffMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateStaffMemberImpl implements UpdateStaffMember {
    private final StaffMemberRepository staffMemberRepository;

    @Override
    public UUID execute(UUID id, StaffMember staffMemberUpdates) {
        StaffMember staffMember = staffMemberRepository.findById(id)
                .orElseThrow(() ->
                        new StaffMemberNotFoundException("Staff member with ID " + id + " not found."));

        if (!staffMemberUpdates.getFullName().isEmpty()) {
            staffMember.setFullName(staffMemberUpdates.getFullName());
        }

        if (!staffMemberUpdates.getEmail().isEmpty()) {
            staffMember.setEmail(staffMemberUpdates.getEmail());
        }

        if (staffMemberUpdates.getRole() != null) {
            staffMember.setRole(staffMemberUpdates.getRole());
        }

        staffMemberRepository.save(staffMember);

        return id;
    }
}
