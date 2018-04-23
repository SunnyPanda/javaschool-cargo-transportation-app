package com.katekozlova.cargo.business.converter;

import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DriverConverter implements Converter<String, Driver> {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverConverter(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver convert(String id) {
        return driverRepository.findById(Long.parseLong(id));
    }
}
