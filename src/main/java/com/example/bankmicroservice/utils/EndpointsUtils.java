package com.example.bankmicroservice.utils;

import lombok.Getter;
import lombok.Setter;

public class EndpointsUtils {

    //Bank APIs
    public static final String ADD_BANK_DETAILS = "/api/v1/bank";
    public static final String GET_BANK_DETAILS = "/api/v1/bank/{bankId}";
    public static final String UPDATE_BANK_DETAILS = "/api/v1/bank/{bankId}";
    public static final String DELETE_BANK_DETAILS = "/api/v1/bank/{bankId}";
    public static final String GET_ALL_BANK_DETAILS = "/api/v1/bank";

    //Branch APIs
    public static final String ADD_BRANCH_DETAILS = "/api/v1/{bankId}/branch/{districtId}";
    public static final String GET_ALL_BRANCHES_OF_BANK = "/api/v1/{bankId}/branch/{districtId}";

    //District APIs
    public static final String ADD_DISTRICT = "/api/v1/{bankId}/district";
    public static final String GET_ALL_DISTRICT = "/api/v1/{bankId}/district";
}
