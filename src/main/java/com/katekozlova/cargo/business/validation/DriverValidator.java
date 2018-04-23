package com.katekozlova.cargo.business.validation;

import com.katekozlova.cargo.data.entity.Driver;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DriverValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Driver.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "personalNumber", "driver.personalNumber.empty");
        ValidationUtils.rejectIfEmpty(errors, "firstName", "driver.firstName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "driver.lastName.empty");
    }
}
