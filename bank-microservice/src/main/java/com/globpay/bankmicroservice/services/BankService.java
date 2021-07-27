package com.globpay.bankmicroservice.services;

import com.globpay.bankmicroservice.entities.Bank;
import com.globpay.bankmicroservice.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public void addBank(Bank newBank) {
        if (bankRepository.count() > 0) {
            for (Bank bank : bankRepository.findAll()) {
                if (bank.getName().equals(newBank.getName())) {
                    return;
                }
                bankRepository.save(newBank);
            }
        }
        bankRepository.save(newBank);
    }

    public Optional<Bank> getBank(String id) {
        return bankRepository.findById(id);
    }

    public List<Bank> getListOfBanks() {
        List<Bank> listOfBanks = new ArrayList<>();
        for (Bank bank : bankRepository.findAll()) {
            listOfBanks.add(bank);
        }
        return listOfBanks;
    }

    public void updateBank(String id, Bank newBankInfo) {
        bankRepository.save(newBankInfo);
    }

    public void deleteBank(String id) {
        bankRepository.deleteById(id);
    }
}
