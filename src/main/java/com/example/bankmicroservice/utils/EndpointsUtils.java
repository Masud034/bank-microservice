package com.example.bankmicroservice.utils;

import lombok.Getter;
import lombok.Setter;

public class EndpointsUtils {
    public static final String ADD_BANK_DETAILS = "/api/v1/bank";
    public static final String GET_BANK_DETAILS = "/api/v1/bank/{bankId}";
    public static final String UPDATE_BANK_DETAILS = "/api/v1/bank/{bankId}";
    public static final String DELETE_BANK_DETAILS = "/api/v1/bank/{bankId}";
    public static final String GET_ALL_BANK_DETAILS = "/api/v1/bank";
}
