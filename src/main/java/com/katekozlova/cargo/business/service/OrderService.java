package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final WaypointRepository waypointRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, WaypointRepository waypointRepository) {
        this.orderRepository = orderRepository;
        this.waypointRepository = waypointRepository;
    }

    public List<Order> getAllOrders() {
        return Lists.newArrayList(orderRepository.findAll());
    }

    public List<Waypoint> getOrdersWaypoints(long id) {
        return Lists.newArrayList(waypointRepository.findAll());
//        List<Waypoint> waypoints = Lists.newArrayList(waypointRepository.findAll());
//        return waypoints;
    }

    public List<Waypoint> getOrdersWaypoints() {
        return Lists.newArrayList(waypointRepository.findAll());

    }
}
