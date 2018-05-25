package com.katekozlova.cargo.business.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.CargoRepository;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonService {

    private final OrderRepository orderRepository;
    private final DriverRepository driverRepository;
    private final CargoRepository cargoRepository;
    private final TruckRepository truckRepository;

    @Autowired
    public JsonService(OrderRepository orderRepository, DriverRepository driverRepository, CargoRepository cargoRepository,
                       TruckRepository truckRepository) {
        this.orderRepository = orderRepository;
        this.driverRepository = driverRepository;
        this.cargoRepository = cargoRepository;
        this.truckRepository = truckRepository;
    }

    public List<Order> generateOrdersJson() {

        return orderRepository.findAll();
    }

    public DriversInfo generateDriversJson() {
        List<Driver> allDrivers = driverRepository.findAll();
        List<Driver> availableDrivers = driverRepository.findByStatus(DriverStatus.REST);
        final long unavailableDrivers = Math.subtractExact(allDrivers.size(), availableDrivers.size());
        return new DriversInfo(allDrivers.size(), availableDrivers.size(), unavailableDrivers);
    }

    public TrucksInfo generateTrucksJson() {
        List<Truck> allTrucks = truckRepository.findAll();
        List<Truck> brokenTrucks = truckRepository.findByState(TruckState.DEFECTIVE);
        List<Truck> onOrderTrucks = truckRepository.findByOrder();
        List<Truck> availableTrucks = truckRepository.findByOrderTruckState(TruckState.SERVICEABLE);

        return new TrucksInfo(allTrucks.size(), availableTrucks.size(), onOrderTrucks.size(), brokenTrucks.size());
    }
}
