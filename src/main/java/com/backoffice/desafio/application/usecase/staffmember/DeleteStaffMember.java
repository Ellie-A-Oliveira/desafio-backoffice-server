package com.backoffice.desafio.application.usecase.staffmember;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface DeleteStaffMember {
    UUID execute(UUID id);
}
