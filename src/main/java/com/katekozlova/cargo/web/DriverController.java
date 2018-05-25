package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.*;
import com.katekozlova.cargo.data.entity.CargoStatus;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final DriverService driverService;
    private final CargoService cargoService;
    private final OrderService orderService;
    private final WaypointService waypointService;

    @Autowired
    public DriverController(DriversService driversService, DriverService driverService, CargoService cargoService, OrderService orderService, WaypointService waypointService) {
        this.driversService = driversService;
        this.driverService = driverService;
        this.cargoService = cargoService;
        this.orderService = orderService;
        this.waypointService = waypointService;
    }

    @GetMapping(value = "/info/{id}")
    public String driversInfo(@PathVariable("id") long id, Driver driver, ModelMap model) {
        driver = driversService.findDriverById(id);
        String message;
        if (driver.getOrder() == null) {
            message = "no";
            return "drivers/id";
        }
        List<Driver> coDrivers = driverService.findByTruck(id);
        List<Waypoint> waypoints = waypointService.getCargoByWaypoints(driver.getOrder().getId());
        message = "yes";
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        model.addAttribute("message", message);
        return "drivers/id";
    }

    @PostMapping(value = "/id/confirm")
    public String confirmStatus(Driver driver, ModelMap model) {
        driversService.updateDriver(driver);
        List<Driver> coDrivers = driverService.findByTruck(driver.getId());
        List<Waypoint> waypoints = waypointService.getCargoByWaypoints(driver.getOrder().getId());
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        return "drivers/id";
    }

    @PostMapping(value = "/id/shiftbegin")
    public String shiftBegin(Driver driver, ModelMap model) {
        driverService.setShiftBeginTime(driver);
        List<Driver> coDrivers = driverService.findByTruck(driver.getId());
        List<Waypoint> waypoints = waypointService.getCargoByWaypoints(driver.getOrder().getId());
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        return "drivers/id";
    }

    @PostMapping(value = "/id/shiftend")
    public String shiftEnd(Driver driver, ModelMap model) {
        driverService.setShiftEnd(driver);
        model.addAttribute("driver", driver);
        return "drivers/id";
    }

    @PostMapping(value = "/id/load/{id}")
    public String loadCargo(@PathVariable("id") long cargoId, Driver driver, ModelMap model) {
        cargoService.setCargoStatus(cargoId, CargoStatus.SHIPPED);
        List<Driver> coDrivers = driverService.findByTruck(driver.getId());
        List<Waypoint> waypoints = waypointService.getCargoByWaypoints(driver.getOrder().getId());
        model.addAttribute("driver", driver);
        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("waypoints", waypoints);
        return "drivers/id";
    }

    @PostMapping(value = "/id/unload/{id}")
    public String unloadCargo(@PathVariable("id") long cargoId, Driver driver, ModelMap model) {
        cargoService.setCargoStatus(cargoId, CargoStatus.DELIVERED);
        List<Driver> coDrivers = driverService.findByTruck(driver.getId());
        List<Waypoint> waypoints = waypointService.getCargoByWaypoints(driver.getOrder().getId());
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
