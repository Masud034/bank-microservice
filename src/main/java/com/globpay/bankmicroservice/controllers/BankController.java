package com.globpay.bankmicroservice.controllers;

import com.globpay.bankmicroservice.entities.Bank;
import com.globpay.bankmicroservice.services.BankService;
import com.globpay.bankmicroservice.validators.BankIdMustExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
public class BankController {

    @Autowired
    private BankService bankService;


    @GetMapping(value = "/banks",produces = "application/json")
    public ResponseEntity<List<Bank>> getAllBanks() {
        return new ResponseEntity<>(bankService.getListOfBanks(), HttpStatus.OK);
    }

    @GetMapping(value = "/bank/{id}", produces = "application/json")
    public ResponseEntity<Bank> getBank(@PathVariable @BankIdMustExist String id) {
        return new ResponseEntity<>(bankService.getBank(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bank", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bank> addBank(@Valid @RequestBody Bank bank) {
        return new ResponseEntity<>(bankService.addBank(bank), HttpStatus.CREATED);
    }

    @PutMapping(value = "/banks/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bank> updateBank(@PathVariable @BankIdMustExist String id, @RequestBody Bank bank) {
        return new ResponseEntity<>(bankService.updateBank(id, bank), HttpStatus.OK);
    }

    @DeleteMapping(value = "/banks/{id}")
    public ResponseEntity deleteBank(@PathVariable @BankIdMustExist String id) {
        bankService.deleteBank(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
