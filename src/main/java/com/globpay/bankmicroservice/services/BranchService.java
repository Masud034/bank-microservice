package com.globpay.bankmicroservice.services;

import com.globpay.bankmicroservice.entities.Bank;
import com.globpay.bankmicroservice.entities.Branch;
import com.globpay.bankmicroservice.exceptions.DuplicateNameException;
import com.globpay.bankmicroservice.exceptions.DuplicateRoutingNumberException;
import com.globpay.bankmicroservice.repositories.BankRepository;
import com.globpay.bankmicroservice.repositories.BranchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BankRepository bankRepository;

    public List<Branch> getListOfBranches(String bankId){
        return branchRepository.findByBankId(bankId);
    }

    public Branch getBranch(String bankId, String branchId){
        return branchRepository.findById(branchId).get();
    }

    public Branch addBranch(String bankId,Branch newBranch){
        if (branchRepository.existsByRoutingNumber(newBranch.getRoutingNumber())){
                throw new DuplicateRoutingNumberException("Branch's routing number already taken");
        }
        newBranch.setBank(bankRepository.findById(bankId).get());
        return branchRepository.save(newBranch);
    }

    public Branch updateBranch(String bankId, String branchId, Branch newBranchInfo){
        Branch oldBranch = branchRepository.findById(branchId).get();
        BeanUtils.copyProperties(newBranchInfo, oldBranch);
        return branchRepository.save(oldBranch);
    }

    public void deleteBranch(String bankId, String branchId){
        branchRepository.deleteById(branchId);
    }

}
