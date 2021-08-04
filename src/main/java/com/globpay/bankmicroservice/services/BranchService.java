package com.globpay.bankmicroservice.services;

import com.globpay.bankmicroservice.entities.Bank;
import com.globpay.bankmicroservice.entities.Branch;
import com.globpay.bankmicroservice.repositories.BankRepository;
import com.globpay.bankmicroservice.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BankRepository bankRepository;

    public List<Branch> getListOfBranches() {
        return branchRepository.findAll();
    }

    public Branch getBranch(String branchId){
        return branchRepository.findById(branchId).get();
    }

    public Branch addBranch(String bankId,Branch newBranch){
        bankRepository.findById(bankId).get().getBranches().add(newBranch);
        newBranch.setBank(bankRepository.findById(bankId).get());
        return branchRepository.save(newBranch);
    }

    public Branch updateBranch(String branchId, Branch newBranchInfo){
        Branch branch = branchRepository.findById(branchId).get();
        branch.setName(newBranchInfo.getName());
        branch.setRoutingNumber(newBranchInfo.getRoutingNumber());
        branch.setSwiftCode(newBranchInfo.getSwiftCode());
        branch.setStatus(newBranchInfo.isStatus());
        return branchRepository.save(branch);
    }

    public void deleteBranch(String branchId){
        branchRepository.deleteById(branchId);
    }

}
