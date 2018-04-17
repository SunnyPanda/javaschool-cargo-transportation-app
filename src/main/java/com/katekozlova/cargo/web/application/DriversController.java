package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.service.DriversService;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.DriverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/drivers")
public class DriversController {

    private final DriversService driversService;

    @Autowired
    public DriversController(DriversService driversService) {
        this.driversService = driversService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list(HttpServletRequest request) {
        System.out.println("request.isUserInRole(\"USER\") = " + request.isUserInRole("USER"));
        System.out.println("request.isUserInRole(\"DRIVER\") = " + request.isUserInRole("DRIVER"));
        List<Driver> drivers = driversService.getAllDrivers();
        return new ModelAndView("drivers/list", "drivers", drivers);
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteDriver(@PathVariable("id") long id) {
        driversService.deleteDriver(id);
        return "redirect:/drivers/list";
    }

    @GetMapping(value = {"/create"})
    public String newDriver(ModelMap model) {
        Driver driver = new Driver();
        model.addAttribute("driver", driver);
        model.addAttribute("edit", false);
        model.addAttribute("statusValues", DriverStatus.values());
        return "drivers/edit";
    }

    @PostMapping(value = "/create")
    public String createDriver(Driver driver) {
        driversService.createAndUpdate(driver);
        return "redirect:/drivers/list";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String editDriver(@PathVariable("id") long id, ModelMap model) {
        Driver driver = driversService.findById(id);
        model.addAttribute("driver", driver);
        model.addAttribute("edit", true);
        model.addAttribute("statusValues", DriverStatus.values());
        return "drivers/edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateDriver(@PathVariable("id") long id, Driver driver) {
        driversService.createAndUpdate(driver);
        return "redirect:/drivers/list";
    }

    @GetMapping(value = "{id}")
    public String driversInfo(@PathVariable("id") long id, ModelMap model) {
        Driver driver = driversService.findById(id);
        List<Driver> coDrivers = driversService.findByTruck(id);
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        return "drivers/id";
    }

//    @GetMapping(value = "{id}")
//    public ModelAndView driversInfo(@PathVariable("id") long id) {
//        Driver driver = driversService.findById(id);
//        return new ModelAndView("drivers/id", "driver", driver);
//    }
}

