package com.example.demo_jenkins.config.validator;

import com.example.demo_jenkins.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidatorService implements ConstraintValidator<MyValidator,Object> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(MyValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
