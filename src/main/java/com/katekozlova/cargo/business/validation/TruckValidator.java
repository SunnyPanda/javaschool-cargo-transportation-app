package com.katekozlova.cargo.business.validation;

import com.katekozlova.cargo.data.entity.Truck;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TruckValidator implements Validator {


    public boolean supports(Class<?> clazz) {
        return Truck.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "regNumber", "truck.regNumber.empty");
        ValidationUtils.rejectIfEmpty(e, "shiftSize", "truck.shiftSize.empty");
        ValidationUtils.rejectIfEmpty(e, "capacity", "truck.capacity.empty");
        // ValidationUtils.rejectIfEmpty(e, "currentCity", "truck.currentCity.empty");

        Truck truck = (Truck) obj;


//        if (p.getAge() < 0) {
//            e.rejectValue("age", "negativevalue");
//        } else if (p.getAge() > 110) {
//            e.rejectValue("age", "too.darn.old");
//        }
    }
}
