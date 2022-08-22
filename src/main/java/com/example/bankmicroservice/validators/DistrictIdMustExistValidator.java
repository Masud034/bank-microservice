package com.example.bankmicroservice.validators;
import com.example.bankmicroservice.repositories.BankRepository;
import com.example.bankmicroservice.repositories.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class DistrictIdMustExistValidator implements ConstraintValidator<DistrictIdMustExist, String> {
    private final DistrictRepository districtRepository;

    public void initialize(DistrictIdMustExist districtIdMustExist) {
    }

    public boolean isValid(String id, ConstraintValidatorContext context) {
        return districtRepository.findById(id).isPresent();
    }
}