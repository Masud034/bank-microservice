package com.example.bankmicroservice.controllers;

import com.example.bankmicroservice.entities.Bank;
import com.example.bankmicroservice.services.BankService;
import com.example.bankmicroservice.utils.EndpointsUtils;
import com.example.bankmicroservice.validators.BankIdMustExist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @PostMapping(value = EndpointsUtils.ADD_BANK_DETAILS, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bank> addBankDetails(@Valid @RequestBody Bank bank) {
        return new ResponseEntity<>(bankService.addBankDetails(bank), HttpStatus.CREATED);
    }

    @GetMapping(value = EndpointsUtils.GET_BANK_DETAILS)
    public ResponseEntity<Bank> getBankDetails(@PathVariable @BankIdMustExist String bankId) {
        return new ResponseEntity<>(bankService.getBankDetails(bankId), HttpStatus.OK);
    }

    @GetMapping(value = EndpointsUtils.GET_ALL_BANK_DETAILS)
    public ResponseEntity<List<Bank>> getAllBankDetails() {
        return new ResponseEntity<>(bankService.getAllBankDetails(), HttpStatus.OK);
    }

    @PutMapping(value = EndpointsUtils.UPDATE_BANK_DETAILS)
    public ResponseEntity<Bank> updateBankDetails(@PathVariable @BankIdMustExist String bankId, @RequestBody Bank bank) {
        return new ResponseEntity<>(bankService.updateBankDetails(bankId, bank), HttpStatus.OK);
    }

    @DeleteMapping(value = EndpointsUtils.DELETE_BANK_DETAILS)
    public ResponseEntity<String> deleteBankDetails(@PathVariable @BankIdMustExist String bankId) {
        bankService.deleteBankDetails(bankId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
