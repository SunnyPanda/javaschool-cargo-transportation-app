package com.katekozlova.cargo.business.converter;

import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CityConverter implements Converter<String, City> {

    private final CityRepository cityRepository;

    @Autowired
    public CityConverter(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City convert(String id) {
        return cityRepository.findById(Long.parseLong(id));
    }
}
