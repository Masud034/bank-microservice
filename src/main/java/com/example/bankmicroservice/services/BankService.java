package com.example.bankmicroservice.services;

import com.example.bankmicroservice.entities.Bank;
import com.example.bankmicroservice.exceptions.DuplicateBankEntryException;
import com.example.bankmicroservice.repositories.BankRepository;
import com.example.bankmicroservice.repositories.BranchRepository;
import com.example.bankmicroservice.repositories.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    private final DistrictRepository districtRepository;

    private final BranchRepository branchRepository;

    public Bank addBankDetails(Bank bank) {
        if (bankRepository.existsBySwiftCode(bank.getSwiftCode()))
            throw new DuplicateBankEntryException("This bank is already registered");
        return bankRepository.save(bank);
    }

    public Bank getBankDetails(String bankId) {
        return bankRepository.findById(bankId).get();
    }
    @Cacheable(value = "banks")
    public List<Bank> getAllBankDetails() {
        return bankRepository.findAllByStatus(true)
                .stream()
                .sorted(Comparator.comparing(Bank::getName))
                .collect(Collectors.toList());
    }

    @Scheduled(fixedRate = 2000)
    @CacheEvict(value = "banks", allEntries = true)
    public void clearCache() {
        System.out.println("I was called at " + LocalTime.now());
    }

    public Bank updateBankDetails(String bankId, Bank bank) {
        Bank fetchedBank = bankRepository.findById(bankId).get();
        fetchedBank.setName(bank.getName());
        fetchedBank.setStatus(bank.isStatus());
        return bankRepository.save(fetchedBank);
    }

    public void deleteBankDetails(String bankId) {
        bankRepository.deleteById(bankId);
        districtRepository.deleteAllByBankId(bankId);
        branchRepository.deleteAllByBankId(bankId);
    }
}
