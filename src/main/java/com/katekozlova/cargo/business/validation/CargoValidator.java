package com.katekozlova.cargo.business.validation;

import com.katekozlova.cargo.data.entity.Cargo;
import com.katekozlova.cargo.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class CargoValidator implements Validator {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoValidator(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Cargo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

//        Cargo cargo = (Cargo) target;

        Long cargoNumber = (Long) target;

        Pattern personalNumberPattern = Pattern.compile("\\d+");
        if (!(personalNumberPattern.matcher(Long.toString(cargoNumber))).matches() || cargoNumber <= 0) {
            errors.rejectValue("number", "cargo.number.invalid");
        }

        List<Cargo> cargoList = cargoRepository.findAll();
        List<Long> cargoNumbers = new ArrayList<>();
        for (Cargo cargo: cargoList) {
            cargoNumbers.add(cargo.getNumber());
        }

        if (!cargoNumbers.contains(cargoNumber)) {
            errors.rejectValue("number", "cargo.number.notexist");
        }
    }
}
