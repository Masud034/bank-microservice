package com.example.bankmicroservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BranchIdMustExistValidator.class)
public @interface BranchIdMustExist {

    String message() default "INVALID Branch Id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
