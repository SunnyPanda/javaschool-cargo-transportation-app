package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.service.DriversService;
import com.katekozlova.cargo.data.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping(value = "/")
public class DriversController {

    private final DriversService driversService;

    @Autowired
    public DriversController(DriversService driversService) {
        this.driversService = driversService;
    }

    @GetMapping
    public ModelAndView list() {
        List<Driver> drivers = driversService.getAllDrivers();
        System.out.println("drivers = " + drivers);
        return new ModelAndView("drivers/list", "drivers", drivers);
    }

    @GetMapping(value = "/drivers/delete/{id}")
    public String deleteDriver(@PathVariable("id") long id) {
        driversService.deleteDriver(id);
        return "redirect:/";
    }

    @GetMapping(value = {"/edit"})
    public String newDriver(ModelMap model) {
        Driver driver = new Driver();
        model.addAttribute("driver", driver);
        model.addAttribute("edit", true);
        return "drivers/edit";
    }

    @PostMapping(value = "/edit")
    public String createDriver(Driver driver) {
        driversService.createAndUpdate(driver);
        return "redirect:/";
    }

    @GetMapping(value = {"/drivers/edit/{id}"})
    public String editDriver(@PathVariable("id") long id,ModelMap model) {
        Optional<Driver> driver = driversService.findById(id);
        model.addAttribute("driver", driver);
        model.addAttribute("edit", true);
        return "drivers/edit";
    }

    @PostMapping(value = "/drivers/edit/{id}")
    public String updateDriver(Driver driver) {
        driversService.createAndUpdate(driver);
        return "redirect:/";
    }
}

