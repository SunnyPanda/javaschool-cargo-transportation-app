package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final WaypointRepository waypointRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, WaypointRepository waypointRepository, DriverRepository driverRepository) {
        this.orderRepository = orderRepository;
        this.waypointRepository = waypointRepository;
        this.driverRepository = driverRepository;
    }

    public List<Order> getAllOrders() {
        return Lists.newArrayList(orderRepository.findAll());
    }

    public List<Waypoint> getOrdersWaypoints(long id) {
        //return Lists.newArrayList(waypointRepository.findAll());
        List<Waypoint> waypoints = Lists.newArrayList(waypointRepository.findAll());
        List<Waypoint> ordersWaypoints = new ArrayList<>();
        for (Waypoint point: waypoints) {
            if (id == point.getOrder().getId()) {
                ordersWaypoints.add(point);
            }
        }
        return ordersWaypoints;
    }

    public List<Driver> getOrdersDrivers(long id) {
//        List<Driver> drivers = Lists.newArrayList(driverRepository.findAll());
//        List<Driver> ordersDrivers = drivers.stream()
//                .filter(driver -> (driver.getOrder() != null) && (id == driver.getOrder().getId()))
//                .collect(Collectors.toList());
//        return ordersDrivers;
        return StreamSupport.stream(driverRepository.findAll().spliterator(), false)
                .filter(driver -> (driver.getOrder() != null) && (id == driver.getOrder().getId()))
                .collect(Collectors.toList());
    }
}
