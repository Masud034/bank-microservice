package com.example.bankmicroservice.services;
import com.example.bankmicroservice.entities.Branch;
import com.example.bankmicroservice.exceptions.DuplicateRoutingNumberException;
import com.example.bankmicroservice.repositories.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        return branchRepository.findByBankIdAndDistrictIdAndStatus(bankId, districtId, true)
                .stream()
                .sorted(Comparator.comparing(Branch :: getName))
                .collect(Collectors.toList());
    }

    public Branch updateBranchDetails(String branchId, Branch branch) {
        Branch fetchedBranch = branchRepository.findById(branchId).get();
        BeanUtils.copyProperties(branch, fetchedBranch);
        fetchedBranch.setId(branchId);
        return branchRepository.save(fetchedBranch);
    }

    public void deleteBranch(String branchId) {
        branchRepository.deleteById(branchId);
    }
}
