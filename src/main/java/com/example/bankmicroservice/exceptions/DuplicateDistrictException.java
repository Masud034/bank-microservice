package com.example.bankmicroservice.exceptions;

public class DuplicateDistrictException extends RuntimeException{
    public DuplicateDistrictException(String message) {
        super(message);
    }
}
