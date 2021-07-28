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
        bankRepository.save(newBank);
    }

    public Bank getBank(String id) {
        return bankRepository.findById(id).get();
    }

    public List<Bank> getListOfBanks() {
        List<Bank> listOfBanks = new ArrayList<>();
        for (Bank bank : bankRepository.findAll()) {
            listOfBanks.add(bank);
        }
        return listOfBanks;
    }

    public void updateBank(String id, Bank newBankInfo) {
        Bank bank = bankRepository.findById(id).get();
        bank.setName(newBankInfo.getName());
        bank.setStatus(newBankInfo.isStatus());
        bankRepository.save(bank);
    }

    public void deleteBank(String id) {
        bankRepository.deleteById(id);
    }
}
