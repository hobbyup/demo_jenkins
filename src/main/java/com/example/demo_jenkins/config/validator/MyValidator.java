package com.example.demo_jenkins.config.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyValidatorService.class )
public @interface MyValidator {

    String message() default "{myself validator}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
