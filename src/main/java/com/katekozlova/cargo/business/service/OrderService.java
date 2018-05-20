package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.*;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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

    public List<Order> getAll() {
        return Lists.newArrayList(orderRepository.findAllOrders());
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
        getOrderIdToWaypoint(order);
        return orderRepository.save(order);
    }

    public Order saveTruckToOrder(Order order) {
        order.getTruck().setOrder(order);
        truckRepository.save(order.getTruck());
        return orderRepository.save(order);
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
        System.out.println("appropriateDrivers = " + appropriateDrivers);
        return appropriateDrivers;
    }

    public Order saveDriversToOrder(Order order) {
        getOrderToDriver(order);
        getTruckToDriver(order);
        return orderRepository.save(order);
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

    private static final String API_KEY = "AIzaSyADJkrdtuvmf2VbH6Ruj0Y_Ftse3fyg3x4";

    public void getOrderToDriver(Order order) {
        for (Driver driver : order.getDrivers()) {
            driver.setOrder(order);
            driverRepository.save(driver);
        }
    }

    public void getTruckToDriver(Order order) {
        for (Driver driver : order.getDrivers()) {
            driver.setCurrentTruck(order.getTruck());
            driverRepository.save(driver);
        }
    }

    public static long getDriveDist(String addrOne, String addrTwo) throws ApiException, InterruptedException, IOException {

        //set up key
        GeoApiContext distCalcer = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer);
        DistanceMatrix result = req.origins(addrOne)
                .destinations(addrTwo)
                .mode(TravelMode.DRIVING)
                .avoid(DirectionsApi.RouteRestriction.TOLLS)
                .language("en-US")
                //.units(Unit.METRIC)
                .await();

        long distApart = result.rows[0].elements[0].distance.inMeters;
        System.out.println("distApart = " + distApart);

        return distApart;
    }

    public void getOrderIdToWaypoint(Order order) {
        for (Waypoint waypoint : order.getWaypoints()) {
            waypoint.setOrder(order);
            waypointRepository.save(waypoint);
        }
    }
//    public GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
//
//
//    public DistanceMatrix estimateRouteTime(DateTime time, Boolean isForCalculateArrivalTime, DirectionsApi.RouteRestriction routeRestriction, String departure, String arrival) {
//        try {
//            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
////            if (isForCalculateArrivalTime) {
////                req.departureTime(time);
////            } else {
////                req.arrivalTime(time);
////            }
////            if (routeRestriction == null) {
////                routeRestriction = DirectionsApi.RouteRestriction.TOLLS;
////            }
//            DistanceMatrix trix = req.units(Unit.METRIC)
//                    .origins(departure)
//                    .destinations(arrival)
//                    .mode(TravelMode.DRIVING)
//                   // .avoid(routeRestriction)
//                   // .language("fr-FR")
//                    .await();
//            return trix;
//
//        } catch (ApiException e) {
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }

    public long getTravelTime(List<Waypoint> waypoints) {
        long travelDistance = 0;
        try {
            getDriveDist("St Petersburg", "Moscow");
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MapDistance mapDistance;
        for (int i = 0; i < waypoints.size() - 1; i++) {
            mapDistance = mapDistanceRepository.findMapDistanceBetweenTwoCities(waypoints.get(i).getCity(),
                    waypoints.get(i + 1).getCity());
            travelDistance += mapDistance.getDisrance();
        }
        return travelDistance / TRUCK_SPEED;
    }
}