package com.katekozlova.cargo.business.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.katekozlova.cargo.data.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonService {

    private final OrderService orderService;
    private final DriversService driversService;
    private final CargoService cargoService;
    private final TrucksService trucksService;

    @Autowired
    public JsonService(OrderService orderService, DriversService driversService, CargoService cargoService, TrucksService trucksService) {
        this.orderService = orderService;
        this.driversService = driversService;
        this.cargoService = cargoService;
        this.trucksService = trucksService;
    }

    public List<Order> generateOrdersJson() throws JsonProcessingException {
        List<Order> orders = orderService.getAllOrders();
        return orders;
    }

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
