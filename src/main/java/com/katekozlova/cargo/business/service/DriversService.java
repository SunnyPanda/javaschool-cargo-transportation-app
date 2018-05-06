package com.katekozlova.cargo.business.service;


import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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
        System.out.println("We're in service");
        return Lists.newArrayList(driverRepository.findAll());
    }

    public void deleteDriver(Driver driver) {
        driverRepository.delete(driver);
    }

    public Driver update(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver create(Driver driver) {
        driver.setDriverStatus(DriverStatus.REST);
        return driverRepository.save(driver);
    }

    public Driver findById(long id) {
        return driverRepository.findById(id);
    }

    public List<Driver> findByTruck(long id) {

        List<Driver> drivers = driverRepository.findByCurrentTruck(driverRepository
                .findById(id).getCurrentTruck());
        return drivers.stream().filter(driver -> driver.getId() != id).collect(Collectors.toList());
    }

    public List<Waypoint> getCargoByWaypoints(long orderId) {
        return waypointRepository.findWaypointsByOrderWaypointType(orderId, WaypointType.SHIPMENT);
    }

    public void setShiftBeginTime(Driver driver) {

        driver.setShiftBegin(new DateTime());
        driver.setDriverStatus(DriverStatus.IN_SHIFT);
        driverRepository.save(driver);
        System.out.println("driver.getShiftBegin() = " + driver.getShiftBegin());
    }

    public List<Driver> findByTruck(Truck truck) {
        return driverRepository.findByCurrentTruck(truck);
    }

    public void setShiftEnd(Driver driver) {
        final DateTime shiftEnd = new DateTime();
        DateTime firstDayOfMonth = shiftEnd.dayOfMonth().withMinimumValue();
        if (DateTimeComparator.getDateOnlyInstance().compare(firstDayOfMonth, driver.getShiftBegin()) < 0) {
            driver.setHoursPerMonth(driver.getHoursPerMonth() + driver.getOrder().getTravelTime());
        } else {
            driver.setHoursPerMonth(0);
            final long hoursBetween = Hours.hoursBetween(firstDayOfMonth, shiftEnd).getHours();
            driver.setHoursPerMonth(hoursBetween);
        }
        driver.setDriverStatus(DriverStatus.REST);
        driver.setCurrentTruck(null);
        driver.setOrder(null);
        driverRepository.save(driver);
    }

//    @Scheduled(fixedRate = 30000, initialDelay = 20000)
//    @Transactional
//    public void scheduleTask() {
//        driverRepository.updateDriver();
//        System.out.println("Траляля");
//    }
}


