package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final WaypointRepository waypointRepository;
    private final DriverRepository driverRepository;
    private final TruckRepository truckRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, WaypointRepository waypointRepository, DriverRepository driverRepository, TruckRepository truckRepository) {
        this.orderRepository = orderRepository;
        this.waypointRepository = waypointRepository;
        this.driverRepository = driverRepository;
        this.truckRepository = truckRepository;
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

    public List<Truck> getTrucks(long id) {

        return truckRepository.findTrucksByTruckStateAndOrderIsNullAndCapacityIsGreaterThan(TruckState.SERVICEABLE,
                findMaxCargoWeight(getOrderWaypoints(id)));
        //truckRepository.findTrucksByTruckStateAndOrderIsNull(TruckState.SERVICEABLE);
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public void addTruckToOrder(long orderId, long truckId) {
        orderRepository.findOrderByUniqueNumber(orderId).setTruck(truckRepository.findTruckById(truckId));
        //truckRepository.findTruckById(truckId).setOrder(orderRepository.findOrderByUniqueNumber(number));
    }

    public Order findById(long id) {
        return orderRepository.findOrderById(id);
    }

    public long findMaxCargoWeight(List<Waypoint> waypoints) {
        long maxWeight = 0;
        long sumWeight = 0;
        for (Waypoint waypoint : waypoints) {
            if (waypoint.getWaypointType().equals(WaypointType.SHIPMENT)) {
                sumWeight += waypoint.getCargo().getWeight();
                maxWeight = Math.max(maxWeight, sumWeight);
            } else {
                sumWeight -= waypoint.getCargo().getWeight();
            }
        }
        return maxWeight;
    }
}
