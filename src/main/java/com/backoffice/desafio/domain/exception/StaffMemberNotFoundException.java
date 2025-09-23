package com.backoffice.desafio.domain.exception;

import jakarta.persistence.EntityNotFoundException;

public class StaffMemberNotFoundException extends EntityNotFoundException {
    public StaffMemberNotFoundException(String message) {
        super(message);
    }
}
