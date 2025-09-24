package com.backoffice.desafio.application.usecase.staffmember.impl;

import com.backoffice.desafio.application.usecase.staffmember.CreateStaffMember;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.enumerator.StaffRole;
import com.backoffice.desafio.infrastructure.data.repository.StaffMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStaffMemberImpl implements CreateStaffMember {
    private final StaffMemberRepository staffMemberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public StaffMember execute(StaffMember staffMemberToBeCreated) throws Exception {
        StaffRole currentRole = staffMemberToBeCreated.getRole();
        if (currentRole.equals(StaffRole.ADMIN) || currentRole.equals(StaffRole.SYSTEM)) {
            throw new Exception("Staff role cannot be created as ADMIN or SYSTEM");
        }
        staffMemberToBeCreated.setPasswordHash(
                passwordEncoder.encode(staffMemberToBeCreated.getPasswordHash())
        );
        return staffMemberRepository.save(staffMemberToBeCreated);
    }
}
