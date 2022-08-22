package com.example.bankmicroservice.controllers;

import com.example.bankmicroservice.entities.Branch;
import com.example.bankmicroservice.services.BranchService;
import com.example.bankmicroservice.utils.EndpointsUtils;
import com.example.bankmicroservice.validators.BankIdMustExist;
import com.example.bankmicroservice.validators.DistrictIdMustExist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping(value = EndpointsUtils.ADD_BRANCH_DETAILS, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Branch addBranch(@PathVariable @BankIdMustExist String bankId, @PathVariable @DistrictIdMustExist String districtId, @Valid @RequestBody Branch branch) {
        return branchService.addBranch(bankId, districtId, branch);
    }

    @GetMapping(value = EndpointsUtils.GET_ALL_BRANCHES_OF_BANK, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Branch> getAllBranches(@PathVariable String bankId, @PathVariable @DistrictIdMustExist String districtId) {
        return branchService.getAllBranches(bankId, districtId);
    }
}
