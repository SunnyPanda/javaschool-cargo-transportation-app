package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.DriversService;
import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.data.entity.CargoStatus;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Waypoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/drivers")
@SessionAttributes("driver")
public class DriverController {

    private final DriversService driversService;
    private final CargoService cargoService;
    private final OrderService orderService;

    public DriverController(DriversService driversService, CargoService cargoService, OrderService orderService) {
        this.driversService = driversService;
        this.cargoService = cargoService;
        this.orderService = orderService;
    }

    @GetMapping(value = "/info/{id}")
    public String driversInfo(@PathVariable("id") long id, Driver driver, ModelMap model) {
        driver = driversService.findById(id);
        String message;
        if (driver.getOrder() == null) {
            message = "no";
            return "drivers/id";
        }
        List<Driver> coDrivers = driversService.findByTruck(id);
        List<Waypoint> waypoints = driversService.getCargoByWaypoints(driver.getOrder().getId());
        message = "yes";
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        model.addAttribute("message", message);
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

    @GetMapping(value = "/waypoints/{id}")
    public String getOrderWaypoints(@PathVariable("id") long id, Driver driver, Model model) {
        List<Waypoint> waypoints = orderService.getOrderWaypoints(driver.getOrder().getId());
        model.addAttribute("waypoints", waypoints);
        model.addAttribute("driver", driver);
        return "drivers/waypoints";
    }
}