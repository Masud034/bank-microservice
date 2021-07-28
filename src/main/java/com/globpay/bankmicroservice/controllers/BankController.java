package com.globpay.bankmicroservice.controllers;

import com.globpay.bankmicroservice.entities.Bank;
import com.globpay.bankmicroservice.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/bank")
    public void addBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
    }

    @GetMapping("/bank/{id}")
    public Optional<Bank> getBank(@PathVariable String id) {
        return bankService.getBank(id);
    }

    @GetMapping("/banks")
    public List<Bank> getAllBanks() {
        return bankService.getListOfBanks();
    }

    @PutMapping("/banks/{id}")
    public void updateBank(@PathVariable String id, @RequestBody Bank bank) {
        bankService.updateBank(id, bank);
    }

    @DeleteMapping(value = "/banks/{id}")
    public void deleteBank(@PathVariable String id) {
        bankService.deleteBank(id);
    }
}
