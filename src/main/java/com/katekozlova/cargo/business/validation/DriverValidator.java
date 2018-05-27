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

        Driver driver = (Driver) target;

        Pattern personalNumberPattern = Pattern.compile("\\d+");
        long number = driver.getPersonalNumber();
        if (!(personalNumberPattern.matcher(Long.toString(number))).matches() || number <= 0) {
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
        if (!(hoursPerMonthPattern.matcher(Long.toString(hours))).matches() || hours > 176 || hours < 0) {
            errors.rejectValue("hoursPerMonth", "driver.hoursPerMonth.invalid");
        }

    }
}
