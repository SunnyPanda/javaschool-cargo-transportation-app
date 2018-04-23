package com.katekozlova.cargo.business.converter;

import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TruckConverter implements Converter<String, Truck> {

    private final TruckRepository truckRepository;

    @Autowired
    public TruckConverter(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @Override
    public Truck convert(String id) {
        return truckRepository.findById(Long.parseLong(id));
    }
}
