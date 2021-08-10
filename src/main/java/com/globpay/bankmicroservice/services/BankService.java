package com.globpay.bankmicroservice.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.globpay.bankmicroservice.entities.Bank;
import com.globpay.bankmicroservice.exceptions.DuplicateNameException;
import com.globpay.bankmicroservice.repositories.BankRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public List<Bank> getListOfBanks() {
        return bankRepository.findAll();
    }

    public Bank getBank(String bankId) {
        return bankRepository.findById(bankId).get();
    }

    public Bank addBank(Bank newBank) {
        if (bankRepository.existsByName(newBank.getName())){
            throw new DuplicateNameException("Bank name already taken");
        }
        return bankRepository.save(newBank);
    }

    public Bank updateBank(String bankId, Bank newBankInfo) {
        Bank oldBank = bankRepository.findById(bankId).get();
        BeanUtils.copyProperties(newBankInfo, oldBank);
        return bankRepository.save(oldBank);
    }

    public void deleteBank(String bankId) {
        bankRepository.deleteById(bankId);
    }
}
