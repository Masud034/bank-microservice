package com.example.bankmicroservice.validators;
import com.example.bankmicroservice.repositories.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class BankIdMustExistValidator implements ConstraintValidator<BankIdMustExist, String> {
    private final BankRepository bankRepository;

    public void initialize(BankIdMustExist bankIdMustExist) {
    }

    public boolean isValid(String id, ConstraintValidatorContext context) {
        return bankRepository.findById(id).isPresent();
    }
}
