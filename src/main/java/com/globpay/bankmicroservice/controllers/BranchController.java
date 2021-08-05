package com.globpay.bankmicroservice.controllers;

import com.globpay.bankmicroservice.entities.Bank;
import com.globpay.bankmicroservice.entities.Branch;
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
    public ResponseEntity<List<Branch>> getAllBranches(@PathVariable @BankIdMustExist String bankId) {
        return new ResponseEntity<>(branchService.getListOfBranches(bankId), HttpStatus.OK);
    }

    @GetMapping(value = "/bank/{bankId}/branch/{branchId}", produces = "application/json")
    public ResponseEntity<Branch> getBranch(@PathVariable @BankIdMustExist String bankId,
                                            @PathVariable @BranchIdMustExist String branchId) {
        return new ResponseEntity<>(branchService.getBranch(branchId), HttpStatus.OK);
    }

    @PostMapping(value = "/bank/{bankId}/branch")
    public ResponseEntity addBranch(@PathVariable @BankIdMustExist String bankId,
                                           @Valid @RequestBody Branch newBranch){

        return new ResponseEntity<>(branchService.addBranch(bankId,newBranch),HttpStatus.CREATED);
    }

    @PutMapping(value = "/banks/{bankId}/branches/{branchId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Branch> updateBank(@PathVariable @BankIdMustExist String bankId,
                                           @PathVariable @BranchIdMustExist String branchId,
                                           @Valid @RequestBody Branch branch) {
        return new ResponseEntity<>(branchService.updateBranch(branchId, branch), HttpStatus.OK);
    }

    @DeleteMapping(value = "/banks/{bankId}/branches/{branchId}")
    public ResponseEntity deleteBranch(@PathVariable @BankIdMustExist String bankId,
                                       @PathVariable @BranchIdMustExist String branchId){
        bankService.getBank(bankId).getBranches().remove(branchService.getBranch(branchId));
        branchService.deleteBranch(branchId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
