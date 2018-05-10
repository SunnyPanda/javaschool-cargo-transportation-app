package com.katekozlova.cargo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.DriversService;
import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.business.service.TrucksService;
import com.katekozlova.cargo.data.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class JsonController {

    private final OrderService orderService;
    private final DriversService driversService;
    private final CargoService cargoService;
    private final TrucksService trucksService;

    @Autowired
    public JsonController(OrderService orderService, DriversService driversService, CargoService cargoService, TrucksService trucksService) {
        this.orderService = orderService;
        this.driversService = driversService;
        this.cargoService = cargoService;
        this.trucksService = trucksService;
    }

    @GetMapping(value = "api/orders", produces = "application/json")
    @ResponseBody
    public List<Order> generateOrdersJson() throws JsonProcessingException {
        List<Order> orders = orderService.getAllOrders();
        return orders;
    }

    @GetMapping(value = "api/drivers", produces = "application/json")
    @ResponseBody
    public DriversInfo generateDriversJson() {
        DriversInfo driversInfo = new DriversInfo();
        List<Driver> drivers = driversService.getAllDrivers();
        List<Driver> restDrivers = driversService.getDriversByStatus(DriverStatus.REST);
        final long allDrivers = drivers.size();
        final long notInShiftDrivers = restDrivers.size();
        final long inShiftDrivers = allDrivers - notInShiftDrivers;
        driversInfo.setAllDrivers(allDrivers);
        driversInfo.setAvailableDrivers(notInShiftDrivers);
        driversInfo.setUnavailableDrivers(inShiftDrivers);
        return driversInfo;
    }

    @GetMapping(value = "api/trucks", produces = "application/json")
    @ResponseBody
    public TrucksInfo generateTrucksJson() {
        TrucksInfo trucksInfo = new TrucksInfo();
        List<Truck> allTrucks = trucksService.getAllTrucks();
        List<Truck> brokenTrucks = trucksService.getTrucksByState(TruckState.DEFECTIVE);
        List<Truck> onOrderTrucks = trucksService.getTrucksWithOrder();
        List<Truck> availableTrucks = trucksService.availableTrucks(TruckState.SERVICEABLE);
        final long allTrucksCount = allTrucks.size();
        final long brokenTrucksCount = brokenTrucks.size();
        final long onOrderTrucksCount = onOrderTrucks.size();
        final long availableTrucksCount = availableTrucks.size();
        trucksInfo.setAllTrucks(allTrucksCount);
        trucksInfo.setAvailableTrucks(availableTrucksCount);
        trucksInfo.setOnOrderTrucks(onOrderTrucksCount);
        trucksInfo.setBrokenTrucks(brokenTrucksCount);
        return trucksInfo;
    }
}
