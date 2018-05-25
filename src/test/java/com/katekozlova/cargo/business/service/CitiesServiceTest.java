package com.katekozlova.cargo.business.service;

import com.google.common.collect.ImmutableList;
import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.repository.CityRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CitiesServiceTest extends MockitoJUnit {

    private static final City city;

    static {
        city = new City();
        city.setId(9);
        city.setName("Moscow");
    }

    @Mock
    private CityRepository cityRepository;
    private CitiesService service;

    @Before
    public void setUp() throws Exception {
        service = new CitiesService(cityRepository);
    }

    @Test
    public void getAllCities() {
        final List<City> cities = ImmutableList.of(city);

        when(cityRepository.findAll()).thenReturn(cities);

        assertEquals(cities, service.getAllCities());
    }
}