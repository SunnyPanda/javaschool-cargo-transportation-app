package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.CitiesService;
import com.katekozlova.cargo.business.service.DriverService;
import com.katekozlova.cargo.business.service.DriversService;
import com.katekozlova.cargo.business.validation.DriverValidator;
import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.entity.Driver;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//import org.apache.log4j.Logger;

@Controller
@RequestMapping(value = "/drivers")
@SessionAttributes("driver")
public class DriversController {

    // Logger logger = Logger.getLogger(DriversController.class);

    private final DriversService driversService;
    private final CitiesService citiesService;
    private final CargoService cargoService;

    private final DriverValidator driverValidator;

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public DriversController(DriversService driversService, CitiesService citiesService, CargoService cargoService, DriverValidator driverValidator, AmqpTemplate amqpTemplate) {
        this.driversService = driversService;
        this.citiesService = citiesService;
        this.cargoService = cargoService;
        this.driverValidator = driverValidator;
        this.amqpTemplate = amqpTemplate;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(driverValidator);
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Driver> drivers = driversService.getAllDrivers();
        return new ModelAndView("drivers/list", "drivers", drivers);
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteDriver(@PathVariable("id") long id, Driver driver) {
        driversService.deleteDriver(driver);
        amqpTemplate.convertAndSend("queue1", "driver");
        return "redirect:/drivers/list";
    }

    @GetMapping(value = {"/create"})
    public String newDriver(ModelMap model) {
        Driver driver = new Driver();
        final List<City> cities = citiesService.getAllCities();
        model.addAttribute("driver", driver);
        model.addAttribute("cities", cities);
        return "drivers/create";
    }

    @PostMapping(value = "/create")
    public String createDriver(@Validated Driver driver, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            final List<City> cities = citiesService.getAllCities();
            model.addAttribute("cities", cities);
            return "drivers/create";
        }
        driversService.createDriver(driver);
        amqpTemplate.convertAndSend("queue", "driver");
        return "redirect:/drivers/list";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String editDriver(@PathVariable("id") long id, ModelMap model) {
        Driver driver = driversService.findDriverById(id);
        final List<City> cities = citiesService.getAllCities();
        model.addAttribute("driver", driver);
        model.addAttribute("cities", cities);
        return "drivers/edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateDriver(@Validated Driver driver, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            final List<City> cities = citiesService.getAllCities();
            model.addAttribute("cities", cities);
            return "drivers/edit";
        }
        driversService.updateDriver(driver);
        amqpTemplate.convertAndSend("queue", "driver");
        return "redirect:/drivers/list";
    }
}

