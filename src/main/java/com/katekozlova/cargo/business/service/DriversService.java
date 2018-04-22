package com.katekozlova.cargo.business.service;


import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.DriverStatus;
import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.entity.WaypointType;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriversService {

    private final DriverRepository driverRepository;
    private final WaypointRepository waypointRepository;
    private final OrderService orderService;

    @Autowired
    public DriversService(DriverRepository driverRepository, WaypointRepository waypointRepository, OrderService orderService) {
        this.driverRepository = driverRepository;
        this.waypointRepository = waypointRepository;
        this.orderService = orderService;
    }

    public List<Driver> getAllDrivers() {
        return Lists.newArrayList ( driverRepository.findAll ( ) );
    }

    public void deleteDriver(long id) {
        driverRepository.deleteById ( id );
    }

    public Driver createAndUpdate(Driver driver) {
        return driverRepository.save ( driver );
    }

    public Driver findById(long id) {
        return driverRepository.findDriverById ( id );
    }

    public List<Driver> findByTruck(long id) {

        List<Driver> drivers = driverRepository.findDriverByCurrentTruck ( driverRepository
                .findDriverById ( id ).getCurrentTruck ( ) );
        return drivers.stream ( ).filter ( driver -> driver.getId ( ) != id ).collect ( Collectors.toList ( ) );
    }

    public List<Waypoint> getCargoByWaypoints(long orderId) {
        return waypointRepository.findWaypointsByOrderIdAndWaypointType ( orderId, WaypointType.SHIPMENT );
    }

    public void setShiftBeginTime(Driver driver) {

        driver.setShiftBegin(new DateTime());
        driver.setDriverStatus(DriverStatus.IN_SHIFT);
        System.out.println("driver.getShiftBegin() = " + driver.getShiftBegin());
    }

    public void setShiftEnd(Driver driver) {
//        final DateTime shiftEnd = new DateTime();
//        DateTime firstDayOfMonth = shiftEnd.dayOfMonth().withMinimumValue();
//        if (DateTimeComparator.getDateOnlyInstance().compare(firstDayOfMonth, driver.getShiftBegin()) < 0) {
//            driver.setHoursPerMonth(driver.getHoursPerMonth() + driver.getOrder().getTravelTime());
//        } else {
//            driver.setHoursPerMonth(0);
//            final long hoursBetween = Hours.hoursBetween(firstDayOfMonth, shiftEnd).getHours();
//            driver.setHoursPerMonth(hoursBetween);
//        }
        driver.setDriverStatus(DriverStatus.REST);
    }

//    @Scheduled(fixedRate = 30000, initialDelay = 20000)
//    @Transactional
//    public void scheduleTask() {
//        driverRepository.updateDriver();
//        System.out.println("Траляля");
//    }
}


