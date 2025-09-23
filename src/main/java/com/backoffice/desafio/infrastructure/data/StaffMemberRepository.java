package com.backoffice.desafio.infrastructure.data;

import com.backoffice.desafio.domain.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffMemberRepository extends JpaRepository<StaffMember, UUID> {
}
