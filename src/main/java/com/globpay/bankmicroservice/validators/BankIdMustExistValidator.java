package com.globpay.bankmicroservice.validators;

import com.globpay.bankmicroservice.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BankIdMustExistValidator implements ConstraintValidator<BankIdMustExist, String> {
    @Autowired
    private BankRepository bankRepository;

    public void initialize(BankIdMustExist constraint) {
    }

    public boolean isValid(String id, ConstraintValidatorContext context) {
        return bankRepository.findById(id).isPresent();
    }
}
