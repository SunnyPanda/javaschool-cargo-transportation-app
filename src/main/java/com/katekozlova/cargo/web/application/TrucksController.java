package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.service.TrucksService;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.entity.TruckState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/trucks")
public class TrucksController {

    private TrucksService trucksService;

    @Autowired
    public TrucksController(TrucksService trucksService) {
        this.trucksService = trucksService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Truck> trucks = trucksService.getAllTrucks();
        return new ModelAndView("trucks/list", "trucks", trucks);
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteTruck(@PathVariable("id") long id) {
        trucksService.deleteTruck(id);
        return "redirect:/trucks/list";
    }

    @GetMapping(value = {"/create"})
    public String newTruck(ModelMap model) {
        Truck truck = new Truck();
        model.addAttribute("truck", truck);
        model.addAttribute("edit", false);
        model.addAttribute("stateValues", TruckState.values());
        return "trucks/edit";
    }

    @PostMapping(value = "/create")
    public String createTruck(Truck truck) {
        trucksService.createAndUpdate(truck);
        return "redirect:/trucks/list";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String editTruck(@PathVariable("id") long id, ModelMap model) {
        Optional<Truck> truck = trucksService.findById(id);
        model.addAttribute("truck", truck);
        model.addAttribute("edit", true);
        model.addAttribute("stateValues", TruckState.values());
        return "trucks/edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateTruck(Truck truck) {
        trucksService.createAndUpdate(truck);
        return "redirect:/trucks/list";
    }
}
