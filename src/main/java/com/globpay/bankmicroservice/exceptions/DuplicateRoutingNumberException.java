package com.globpay.bankmicroservice.exceptions;

public class DuplicateRoutingNumberException extends RuntimeException{
    public DuplicateRoutingNumberException(String message){
        super(message);
    }
}
