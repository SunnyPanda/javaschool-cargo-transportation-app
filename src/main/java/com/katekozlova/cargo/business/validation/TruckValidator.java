package com.katekozlova.cargo.business.validation;

import com.katekozlova.cargo.data.entity.Truck;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class TruckValidator implements Validator {


    public boolean supports(Class<?> clazz) {
        return Truck.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {

        Truck truck = (Truck) obj;

        Pattern regNumberPattern = Pattern.compile("[A-Z]{2}\\d{5}");
        if (!regNumberPattern.matcher(truck.getRegNumber()).matches()) {
            e.rejectValue("regNumber", "truck.regNumber.invalid");
        }

        Pattern shiftSizePattern = Pattern.compile("\\d");
        long shift = truck.getShiftSize();
        if (!(shiftSizePattern.matcher(Long.toString(shift))).matches() && shift > 0 && shift < 5) {
            e.rejectValue("siftSize", "driver.siftSize.invalid");
        }

        Pattern capacityPattern = Pattern.compile("\\d+");
        long capacity = truck.getCapacity();
        if (!(shiftSizePattern.matcher(Long.toString(capacity))).matches()) {
            e.rejectValue("capacity", "driver.capacity.invalid");
        }
    }
}
