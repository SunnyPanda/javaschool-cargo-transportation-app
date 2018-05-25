package com.katekozlova.cargo.business.validation;

import com.katekozlova.cargo.data.entity.Waypoint;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class WaypointValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Waypoint.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
