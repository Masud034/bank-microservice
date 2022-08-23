package com.example.bankmicroservice.controllers;

import com.example.bankmicroservice.entities.Branch;
import com.example.bankmicroservice.services.BranchService;
import com.example.bankmicroservice.utils.EndpointsUtils;
import com.example.bankmicroservice.validators.BankIdMustExist;
import com.example.bankmicroservice.validators.BranchIdMustExist;
import com.example.bankmicroservice.validators.DistrictIdMustExist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    //adds a branch mapped with bank and district
    @PostMapping(value = EndpointsUtils.ADD_BRANCH_DETAILS, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Branch> addBranch(@PathVariable @BankIdMustExist String bankId,
                                           @PathVariable @DistrictIdMustExist String districtId,
                                           @Valid @RequestBody Branch branch) {
        return new ResponseEntity<>(branchService.addBranch(bankId, districtId, branch), HttpStatus.CREATED);
    }

    @GetMapping(value = EndpointsUtils.GET_ALL_BRANCHES_OF_BANK, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Branch>> getAllBranches(@PathVariable @BankIdMustExist String bankId, @PathVariable @DistrictIdMustExist String districtId) {
        return new ResponseEntity<>(branchService.getAllBranches(bankId, districtId), HttpStatus.OK);
    }

    @PutMapping(value = EndpointsUtils.UPDATE_BRANCH_DETAILS)
    public ResponseEntity<Branch> updateBranchDetails(@PathVariable @BranchIdMustExist String branchId, Branch branch) {
        return new ResponseEntity<>(branchService.updateBranchDetails(branchId, branch), HttpStatus.OK);
    }

    @DeleteMapping(value = EndpointsUtils.DELETE_BRANCH)
    public ResponseEntity<String> deleteBranch(@PathVariable @BranchIdMustExist String branchId) {
        branchService.deleteBranch(branchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
