package com.backoffice.desafio.infrastructure.data.repository;

import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.enumerator.StaffRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffMemberRepository extends JpaRepository<StaffMember, UUID> {
    StaffMember findFirstByRole(StaffRole role);
    StaffMember findByEmail(String email);
}
