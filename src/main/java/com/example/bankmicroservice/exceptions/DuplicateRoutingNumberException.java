package com.example.bankmicroservice.exceptions;

public class DuplicateRoutingNumberException extends RuntimeException{
    public DuplicateRoutingNumberException(String message) {
        super(message);
    }
}
