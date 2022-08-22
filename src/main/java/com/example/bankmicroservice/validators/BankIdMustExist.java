package com.example.bankmicroservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BankIdMustExistValidator.class)
public @interface BankIdMustExist {

    String message() default "Bank Id INVALID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
