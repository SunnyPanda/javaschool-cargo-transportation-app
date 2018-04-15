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

import java.util.List;

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

    public List<Waypoint> getOrderWaypoints(long id) {
        return waypointRepository.findByOrderId(id);
    }

    public List<Driver> getOrdersDrivers(long id) {
        return driverRepository.findDriverByOrderId(id);
    }
}
