package com.backoffice.desafio.domain.exception;

import jakarta.persistence.EntityNotFoundException;

public class TransactionNotFoundException extends EntityNotFoundException {
    public TransactionNotFoundException(String message) {
        super(message);
    }
}
