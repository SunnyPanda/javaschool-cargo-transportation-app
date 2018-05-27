package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonService {

    static final Logger logger = LoggerFactory.getLogger(JsonService.class);

    private final OrderRepository orderRepository;
    private final DriverRepository driverRepository;
    private final TruckRepository truckRepository;
    private final OrderService orderService;

    @Autowired
    public JsonService(OrderRepository orderRepository, DriverRepository driverRepository, TruckRepository truckRepository,
                       OrderService orderService) {
        this.orderRepository = orderRepository;
        this.driverRepository = driverRepository;
        this.truckRepository = truckRepository;
        this.orderService = orderService;
    }

    public List<Order> generateOrdersJson() {
        logger.info("list of orders was requested");
        return orderRepository.findAll();
    }

    public DriversInfo generateDriversJson() {
        List<Driver> allDrivers = driverRepository.findAll();
        List<Driver> availableDrivers = driverRepository.findByStatus(DriverStatus.REST);
        final long unavailableDrivers = Math.subtractExact(allDrivers.size(), availableDrivers.size());
        DriversInfo driversInfo = new DriversInfo(allDrivers.size(), availableDrivers.size(), unavailableDrivers);
        logger.info("information about drivers was requested: {}", driversInfo);
        return driversInfo;
    }

    public TrucksInfo generateTrucksJson() {
        List<Truck> allTrucks = truckRepository.findAll();
        List<Truck> brokenTrucks = truckRepository.findByState(TruckState.DEFECTIVE);
        List<Truck> onOrderTrucks = truckRepository.findByOrder();
        List<Truck> availableTrucks = truckRepository.findByOrderTruckState(TruckState.SERVICEABLE);
        TrucksInfo trucksInfo = new TrucksInfo(allTrucks.size(), availableTrucks.size(), onOrderTrucks.size(), brokenTrucks.size());
        logger.info("information about trucks was requested: {}", trucksInfo);
        return trucksInfo;
    }

    public String[] route(long id) {
        Order order = orderRepository.findById(id);
        List<Waypoint> waypoints = order.getWaypoints();
        if (waypoints == null) {
            orderService.getOrderWaypoints(id);
        }

        List<String> waypointList = new ArrayList<>();
        for (Waypoint waypoint: waypoints) {
            waypointList.add(waypoint.getCity().getName());
        }
        logger.info("list of cities from order's waypoints was requested: {}", waypointList);
        return waypointList.toArray(new String[0]);
    }
}
