package com.globpay.bankmicroservice.exceptions;

public class DuplicateNameException extends RuntimeException{

    public DuplicateNameException(String message) {
        super(message);
    }
}
