package com.backoffice.desafio.application.usecase;

import com.backoffice.desafio.domain.entity.StaffMember;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface DeleteStaffMember {
    UUID execute(UUID id);
}
