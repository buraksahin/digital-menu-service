package com.levelupcorp.emenube.util.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerNameValidator implements ConstraintValidator<CustomerNameValidation, String> {
    @Override
    public boolean isValid(String customerName, ConstraintValidatorContext cxt) {
        if(customerName != null && customerName.length() > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
