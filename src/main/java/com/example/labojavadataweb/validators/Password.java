package com.example.labojavadataweb.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = PasswordValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})

public @interface Password {

    String message() default "is not a valid password. Password must be minimum eight characters, at least one letter and one number";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}