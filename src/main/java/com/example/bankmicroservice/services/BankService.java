package com.example.bankmicroservice.services;

import com.example.bankmicroservice.entities.Bank;
import com.example.bankmicroservice.repositories.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public Bank addBankDetails(Bank bank) {
        return bankRepository.save(bank);
    }

    public Bank getBankDetails(String bankId) {
        return bankRepository.findById(bankId).get();
    }

    public List<Bank> getAllBankDetails() {
        return bankRepository.findAll();
    }

    public Bank updateBankDetails(String bankId, Bank bank) {
        Bank fetchedBank = bankRepository.findById(bankId).get();
        fetchedBank.setName(bank.getName());
        fetchedBank.setStatus(bank.isStatus());
        return bankRepository.save(fetchedBank);
    }

    public void deleteBankDetails(String bankId) {
        bankRepository.deleteById(bankId);
    }
}
