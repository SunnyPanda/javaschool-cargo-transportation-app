package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.CitiesService;
import com.katekozlova.cargo.business.service.TrucksService;
import com.katekozlova.cargo.business.validation.TruckValidator;
import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.entity.TruckState;
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

@Controller
@RequestMapping(value = "/manager/trucks")
public class TrucksController {

    private final TrucksService trucksService;
    private final CitiesService citiesService;

    private final TruckValidator truckValidator;

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public TrucksController(TrucksService trucksService, CitiesService citiesService, TruckValidator truckValidator, AmqpTemplate amqpTemplate) {
        this.trucksService = trucksService;
        this.citiesService = citiesService;
        this.truckValidator = truckValidator;
        this.amqpTemplate = amqpTemplate;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(truckValidator);
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Truck> trucks = trucksService.getAllTrucks();
        return new ModelAndView("trucks/list", "trucks", trucks);
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteTruck(@PathVariable("id") long id, Truck truck) {

        trucksService.deleteTruck(truck);
        amqpTemplate.convertAndSend("queue", "truck");
        return "redirect:/manager/trucks/list";
    }

    @GetMapping(value = {"/create"})
    public String newTruck(ModelMap model) {
        Truck truck = new Truck();
        final List<City> cities = citiesService.getAllCities();
        model.addAttribute("truck", truck);
        model.addAttribute("stateValues", TruckState.values());
        model.addAttribute("cities", cities);
        return "trucks/create";
    }

    @PostMapping(value = "/create")
    public String createTruck(@Validated Truck truck, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            final List<City> cities = citiesService.getAllCities();
            model.addAttribute("cities", cities);
            model.addAttribute("stateValues", TruckState.values());
            return "trucks/create";
        }
        trucksService.createAndUpdate(truck);
        amqpTemplate.convertAndSend("queue", "truck");
        return "redirect:/manager/trucks/list";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String editTruck(@PathVariable("id") long id, ModelMap model) {
        Truck truck = trucksService.findById(id);
        final List<City> cities = citiesService.getAllCities();
        model.addAttribute("truck", truck);
        model.addAttribute("stateValues", TruckState.values());
        model.addAttribute("cities", cities);
        return "trucks/edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateTruck(@Validated Truck truck, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            final List<City> cities = citiesService.getAllCities();
            model.addAttribute("cities", cities);
            model.addAttribute("stateValues", TruckState.values());
            return "trucks/edit";
        }
        trucksService.createAndUpdate(truck);
        amqpTemplate.convertAndSend("queue", "truck");
        return "redirect:/manager/trucks/list";
    }
}
