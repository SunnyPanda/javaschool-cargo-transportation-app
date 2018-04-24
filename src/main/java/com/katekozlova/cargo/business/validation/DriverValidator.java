package com.katekozlova.cargo.business.validation;

import com.katekozlova.cargo.data.entity.Driver;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class DriverValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Driver.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ValidationUtils.rejectIfEmpty(errors, "personalNumber", "driver.personalNumber.empty");
//        ValidationUtils.rejectIfEmpty(errors, "firstName", "driver.firstName.empty");
//        ValidationUtils.rejectIfEmpty(errors, "lastName", "driver.lastName.empty");

        Driver driver = (Driver) target;

        Pattern personalNumberPattern = Pattern.compile("\\d+");
        if (!(personalNumberPattern.matcher(Long.toString(driver.getPersonalNumber()))).matches()) {
            errors.rejectValue("personalNumber", "driver.personalNumber.invalid");
        }

        Pattern firstNamePattern = Pattern.compile("[a-zA-z]+");
        if (!(firstNamePattern.matcher((driver.getFirstName()))).matches()) {
            errors.rejectValue("firstName", "driver.firstName.invalid");
        }

        Pattern lastNamePattern = Pattern.compile("[a-zA-z]+");
        if (!(lastNamePattern.matcher((driver.getLastName()))).matches()) {
            errors.rejectValue("lastName", "driver.lastName.invalid");
        }

        Pattern hoursPerMonthPattern = Pattern.compile("\\d+");
        long hours = driver.getHoursPerMonth();
        if (!(hoursPerMonthPattern.matcher(Long.toString(hours))).matches() && hours > 176) {
            errors.rejectValue("hoursPerMonth", "driver.hoursPerMonth.invalid");
        }
    }
}
