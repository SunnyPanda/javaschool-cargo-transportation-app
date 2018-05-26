package com.katekozlova.cargo.business.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Iterables;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.CargoRepository;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonService {

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

        return waypointList.toArray(new String[0]);

//        System.out.println("waypoints" + waypoints);
//        GeoApiContext context = new GeoApiContext.Builder()
//                .apiKey("AIzaSyAVIHJyzMB3OZ9HPs8oQJHGHorJboK2zog")
//                .build();
//
//         DirectionsResult result = DirectionsApi.newRequest(context)
//                .origin(waypoints.get(0).getCity().getName())
//                .destination(waypoints.get(waypoints.size() - 1 ).getCity().getName())
//                .waypoints(waypoints(waypoints))
//                .mode(TravelMode.DRIVING)
//                .awaitIgnoreError();
//
//         return result;
    }

    private String[] waypoints(List<Waypoint> waypointList){
        List<String> waypoints = new ArrayList<>();
        for (int i = 1; i < waypointList.size() - 2; i++) {
            waypoints.add(waypointList.get(i).getCity().getName());
        }
        return waypoints.toArray(new String[0]);
    }
}
