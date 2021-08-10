package com.globpay.bankmicroservice.controllers;

import com.globpay.bankmicroservice.entities.Bank;
import com.globpay.bankmicroservice.entities.Branch;
import com.globpay.bankmicroservice.model.ApiResponse;
import com.globpay.bankmicroservice.services.BankService;
import com.globpay.bankmicroservice.services.BranchService;
import com.globpay.bankmicroservice.validators.BankIdMustExist;
import com.globpay.bankmicroservice.validators.BranchIdMustExist;
import net.bytebuddy.build.ToStringPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class BranchController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private BankService bankService;

    @GetMapping(value = "/banks/{bankId}/branches",produces = "application/json")
    public ResponseEntity<ApiResponse> getAllBranches(@PathVariable @BankIdMustExist String bankId) {
        return new ResponseEntity<>(new ApiResponse("Success", branchService.getListOfBranches(bankId)), HttpStatus.OK);
    }

    @GetMapping(value = "/bank/{bankId}/branch/{branchId}", produces = "application/json")
    public ResponseEntity<ApiResponse> getBranch(@PathVariable @BankIdMustExist String bankId,
                                            @PathVariable @BranchIdMustExist String branchId) {
        return new ResponseEntity<>(new ApiResponse("Success", branchService.getBranch(bankId, branchId)), HttpStatus.OK);
    }

    @PostMapping(value = "/bank/{bankId}/branch")
    public ResponseEntity<ApiResponse> addBranch(@PathVariable @BankIdMustExist String bankId,
                                           @Valid @RequestBody Branch newBranch){

        return new ResponseEntity<>(new ApiResponse("Success", branchService.addBranch(bankId, newBranch)),HttpStatus.CREATED);
    }

    @PutMapping(value = "/banks/{bankId}/branches/{branchId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse> updateBank(@PathVariable @BankIdMustExist String bankId,
                                           @PathVariable @BranchIdMustExist String branchId,
                                           @Valid @RequestBody Branch branch) {
        return new ResponseEntity<>(new ApiResponse("Success", branchService.updateBranch(bankId, branchId, branch)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/banks/{bankId}/branches/{branchId}")
    public ResponseEntity<ApiResponse> deleteBranch(@PathVariable @BankIdMustExist String bankId,
                                       @PathVariable @BranchIdMustExist String branchId){
        bankService.getBank(bankId).getBranches().remove(branchService.getBranch(bankId, branchId));
        branchService.deleteBranch(bankId, branchId);
        return new ResponseEntity(new ApiResponse("Deleted"), HttpStatus.NO_CONTENT);
    }

}
