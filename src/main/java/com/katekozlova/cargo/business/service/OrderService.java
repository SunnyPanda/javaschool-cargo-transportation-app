package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.*;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private static final long TRUCK_SPEED = 70;

    private final OrderRepository orderRepository;
    private final WaypointRepository waypointRepository;
    private final DriverRepository driverRepository;
    private final TruckRepository truckRepository;
    private final MapDistanceRepository mapDistanceRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, WaypointRepository waypointRepository, DriverRepository driverRepository, TruckRepository truckRepository, MapDistanceRepository mapDistanceRepository) {
        this.orderRepository = orderRepository;
        this.waypointRepository = waypointRepository;
        this.driverRepository = driverRepository;
        this.truckRepository = truckRepository;
        this.mapDistanceRepository = mapDistanceRepository;
    }

    public List<Order> getAllOrders() {
        return Lists.newArrayList(orderRepository.findAll());
    }

    public List<Waypoint> getOrderWaypoints(long id) {
        return waypointRepository.findByOrder(id);
    }

    public List<Driver> getOrdersDrivers(long id) {
        return driverRepository.findByOrder(id);
    }

    public List<Truck> getTrucks(long id) {

        return truckRepository.findByOrderTruckStateCapacity(TruckState.SERVICEABLE,
                findMaxCargoWeight(getOrderWaypoints(id)));
        //truckRepository.findTrucksByTruckStateAndOrderIsNull(TruckState.SERVICEABLE);
    }

    public Order create(Order order) {
        order.setOrderStatus(OrderStatus.NO);
        return orderRepository.save(order);
    }

    public Order saveWaipoints(Order order) {
        // checkWaypoints(order.getWaypoints ());
        getOrderIdToWaypoint(order);
        return orderRepository.save(order);
    }

    public Order saveTruckToOrder(Order order) {
        order.getTruck ( ).setOrder ( order );
        return orderRepository.save ( order );
    }

    public void addTruckToOrder(long orderId, long truckId) {
        orderRepository.findByUniqueNumber(orderId).setTruck(truckRepository.findById(truckId));
        //truckRepository.findTruckById(truckId).setOrder(orderRepository.findOrderByUniqueNumber(number));
    }

    public List<Driver> getDrivers(Order order) {
        return getDriversByHours(driverRepository.findByOrderAndCurrentCity(order.getTruck()
                .getCurrentCity().getId()), order);
    }

    public List<Driver> getDriversByHours(List<Driver> drivers, Order order) {
        List<Driver> appropriateDrivers = new ArrayList<>();
        final DateTime now = new DateTime();
        final DateTime endOfMonth = now.dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue();
        final long hoursBetween = Hours.hoursBetween(now, endOfMonth).getHours();

        order.setTravelTime(getTravelTime(order.getWaypoints()));
        for (Driver driver : drivers) {
            if (driver.getHoursPerMonth() + Math.min(hoursBetween, order.getTravelTime()) <= 176) {
                appropriateDrivers.add(driver);
            }
        }
        return appropriateDrivers;
    }

    public Order saveDriversToOrder(Order order) {
        getOrderToDriver(order);
        getTruckToDriver(order);
        return orderRepository.save ( order );
    }

    public Order findById(long id) {
        return orderRepository.findById(id);
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
        return orderRepository.findByUniqueNumber(uniqueNumber);
    }

//    public boolean checkWaypoints(List<Waypoint> waypoints) {
//        for ( Waypoint waypoint : waypoints ) {
//            if (waypoint.getWaypointType ( ) == WaypointType.SHIPMENT) {
//                waypointRepository.findWaypointsByCargoIdAndWaypointType ( waypoint.getCargo ( ).getId ( ), WaypointType.LANDING );
//            } else {
//                waypointRepository.findWaypointsByCargoIdAndWaypointType ( waypoint.getCargo ( ).getId ( ), WaypointType.SHIPMENT );
//            }
//        }
//
//        return true;
//    }

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

    public void getTruckToDriver(Order order) {
        for (Driver driver : order.getDrivers()) {
            driver.setCurrentTruck(order.getTruck());
        }
    }

    public long getTravelTime(List<Waypoint> waypoints) {
        long travelDistance = 0;
        MapDistance mapDistance;
        for (int i = 0; i < waypoints.size() - 1; i++) {
            mapDistance = mapDistanceRepository.findMapDistanceBetweenTwoCities(waypoints.get(i).getCity(),
                    waypoints.get(i + 1).getCity());
            if (mapDistance == null) {
                mapDistance = mapDistanceRepository.findMapDistanceBetweenTwoCities(waypoints.get(i + 1).getCity(),
                        waypoints.get(i).getCity());
            }
            travelDistance += mapDistance.getDisrance();
        }
        return travelDistance / TRUCK_SPEED;
    }
}
