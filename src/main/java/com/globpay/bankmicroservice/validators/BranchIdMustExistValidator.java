package com.globpay.bankmicroservice.validators;

import com.globpay.bankmicroservice.entities.Branch;
import com.globpay.bankmicroservice.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BranchIdMustExistValidator implements ConstraintValidator<BranchIdMustExist, String> {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public void initialize(BranchIdMustExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String branchId, ConstraintValidatorContext constraintValidatorContext) {
        return branchRepository.findById(branchId).isPresent();
    }
}
