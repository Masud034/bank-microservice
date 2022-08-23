package com.example.bankmicroservice.validators;
import com.example.bankmicroservice.repositories.BankRepository;
import com.example.bankmicroservice.repositories.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class BranchIdMustExistValidator implements ConstraintValidator<BranchIdMustExist, String> {
    private final BranchRepository branchRepository;

    public void initialize(BranchIdMustExist branchIdMustExist) {
    }

    public boolean isValid(String id, ConstraintValidatorContext context) {
        return branchRepository.findById(id).isPresent();
    }
}

