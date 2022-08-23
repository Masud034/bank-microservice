package com.example.bankmicroservice.exceptions;

public class DuplicateBankEntryException extends RuntimeException {
    public DuplicateBankEntryException(String message) {
        super(message);
    }
}
