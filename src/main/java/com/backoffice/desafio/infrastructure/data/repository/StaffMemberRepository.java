package com.backoffice.desafio.infrastructure.data.repository;

import com.backoffice.desafio.domain.entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffMemberRepository extends JpaRepository<StaffMember, UUID> {
}
