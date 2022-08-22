package com.example.bankmicroservice.services;

import com.example.bankmicroservice.entities.Branch;
import com.example.bankmicroservice.exceptions.DuplicateRoutingNumberException;
import com.example.bankmicroservice.repositories.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;


    public Branch addBranch(String bankId, String districtId, Branch branch) {
        if (branchRepository.existsByRoutingNumber(branch.getRoutingNumber()))
            throw new DuplicateRoutingNumberException("This branch is already taken");
        branch.setBankId(bankId);
        branch.setDistrictId(districtId);
        return branchRepository.save(branch);
    }

    public List<Branch> getAllBranches(String bankId, String districtId) {
        return branchRepository.findByBankIdAndDistrictId(bankId, districtId);
    }
}
