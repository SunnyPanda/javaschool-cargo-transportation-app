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
        order.setOrderStatus ( OrderStatus.NO );
        return orderRepository.save(order);
    }

    public Order saveWaipoints(Order order) {
        // checkWaypoints(order.getWaypoints ());
        getOrderIdToWaypoint ( order );
        return orderRepository.save ( order );
    }

    public Order saveTruckToOrder(Order order) {
        order.getTruck ( ).setOrder ( order );
        return orderRepository.save ( order );
    }

    public void addTruckToOrder(long orderId, long truckId) {
        orderRepository.findOrderByUniqueNumber(orderId).setTruck(truckRepository.findTruckById(truckId));
        //truckRepository.findTruckById(truckId).setOrder(orderRepository.findOrderByUniqueNumber(number));
    }

    public List<Driver> getDrivers(Order order) {
        return driverRepository.findDriverByOrderIsNullAndCurrentCityId ( order.getTruck ( )
                .getCurrentCity ( ).getId ( ) );
    }

    public Order saveDriversToOrder(Order order) {
        getOrderToDriver ( order );
        return orderRepository.save ( order );
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

    public Order findByUniqueNumber(long uniqueNumber) {
        return orderRepository.findOrderByUniqueNumber(uniqueNumber);
    }

    public boolean checkWaypoints(List<Waypoint> waypoints) {
        for ( Waypoint waypoint : waypoints ) {
            if (waypoint.getWaypointType ( ) == WaypointType.SHIPMENT) {
                waypointRepository.findWaypointsByCargoIdAndWaypointType ( waypoint.getCargo ( ).getId ( ), WaypointType.LANDING );
            } else {
                waypointRepository.findWaypointsByCargoIdAndWaypointType ( waypoint.getCargo ( ).getId ( ), WaypointType.SHIPMENT );
            }
        }

        return true;
    }

    public void getOrderIdToWaypoint(Order order) {
        for ( Waypoint waypoint : order.getWaypoints ( ) ) {
            waypoint.setOrder ( order );
        }
    }

    public void getOrderToDriver(Order order) {
        for ( Driver driver : order.getDrivers ( ) ) {
            driver.setOrder ( order );
        }
    }
}
