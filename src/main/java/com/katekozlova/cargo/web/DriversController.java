package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.CitiesService;
import com.katekozlova.cargo.business.service.DriversService;
import com.katekozlova.cargo.business.validation.DriverValidator;
import com.katekozlova.cargo.data.entity.CargoStatus;
import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Waypoint;
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
@RequestMapping(value = "/drivers")
@SessionAttributes("driver")
public class DriversController {

    private final DriversService driversService;
    private final CitiesService citiesService;
    private final CargoService cargoService;

    private final DriverValidator driverValidator;

    @Autowired
    public DriversController(DriversService driversService, CitiesService citiesService, CargoService cargoService, DriverValidator driverValidator) {
        this.driversService = driversService;
        this.citiesService = citiesService;
        this.cargoService = cargoService;
        this.driverValidator = driverValidator;
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
        return "redirect:/drivers/list";
    }

    @GetMapping(value = {"/create"})
    public String newDriver(ModelMap model) {
        Driver driver = new Driver();
        final List<City> cities = citiesService.getAllCities();
        model.addAttribute("driver", driver);
        // model.addAttribute("statusValues", DriverStatus.values());
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
        driversService.create(driver);
        return "redirect:/drivers/list";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String editDriver(@PathVariable("id") long id, ModelMap model) {
        Driver driver = driversService.findById(id);
        final List<City> cities = citiesService.getAllCities();
        model.addAttribute("driver", driver);
        //model.addAttribute("statusValues", DriverStatus.values());
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
        driversService.update(driver);
        return "redirect:/drivers/list";
    }

    @GetMapping(value = "/info/{id}")
    public String driversInfo(@PathVariable("id") long id, Driver driver, ModelMap model) {
        driver = driversService.findById(id);
        List<Driver> coDrivers = driversService.findByTruck(id);
        List<Waypoint> waypoints = driversService.getCargoByWaypoints(driver.getOrder().getId());
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        return "drivers/id";
    }

    @PostMapping(value = "/id/confirm")
    public String confirmStatus(Driver driver, ModelMap model) {
        driversService.update(driver);
        List<Driver> coDrivers = driversService.findByTruck(driver.getId());
        List<Waypoint> waypoints = driversService.getCargoByWaypoints(driver.getOrder().getId());
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        return "drivers/id";
    }

    @PostMapping(value = "/id/shiftbegin")
    public String shiftBegin(Driver driver, ModelMap model) {
        driversService.setShiftBeginTime(driver);
        List<Driver> coDrivers = driversService.findByTruck(driver.getId());
        List<Waypoint> waypoints = driversService.getCargoByWaypoints(driver.getOrder().getId());
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        return "drivers/id";
    }

    @PostMapping(value = "/id/shiftend")
    public String shiftEnd(Driver driver, ModelMap model) {
        driversService.setShiftEnd(driver);
        model.addAttribute("driver", driver);
        return "drivers/id";
    }

    @PostMapping(value = "/id/load/{id}")
    public String loadCargo(@PathVariable("id") long cargoId, Driver driver, ModelMap model) {
        cargoService.setCargoStatus(cargoId, CargoStatus.SHIPPED);
        List<Driver> coDrivers = driversService.findByTruck(driver.getId());
        List<Waypoint> waypoints = driversService.getCargoByWaypoints(driver.getOrder().getId());
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        return "drivers/id";
    }

    @PostMapping(value = "/id/unload/{id}")
    public String unloadCargo(@PathVariable("id") long cargoId, Driver driver, ModelMap model) {
        cargoService.setCargoStatus(cargoId, CargoStatus.DELIVERED);
        List<Driver> coDrivers = driversService.findByTruck(driver.getId());
        List<Waypoint> waypoints = driversService.getCargoByWaypoints(driver.getOrder().getId());
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        return "drivers/id";
    }
}

