package com.Bank.app.domain.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}