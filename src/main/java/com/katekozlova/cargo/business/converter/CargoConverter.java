package com.katekozlova.cargo.business.converter;

import com.katekozlova.cargo.data.entity.Cargo;
import com.katekozlova.cargo.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CargoConverter implements Converter<String, Cargo> {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoConverter(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public Cargo convert(String id) {
        return cargoRepository.findById(Long.parseLong(id));
    }
}
