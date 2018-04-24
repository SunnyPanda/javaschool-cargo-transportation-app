package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.CitiesService;
import com.katekozlova.cargo.data.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/cities")
public class CityController {

    private final CitiesService citiesService;

    @Autowired
    public CityController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<City> cities = citiesService.getAllCities();
        return new ModelAndView("cities/list", "cities", cities);
    }
}
