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

    @Autowired
    public DriversService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return Lists.newArrayList(driverRepository.findAll());
    }

    public void deleteDriver(Driver driver) {
        driverRepository.delete(driver);
    }

    public Driver updateDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver createDriver(Driver driver) {
        driver.setDriverStatus(DriverStatus.REST);
        return driverRepository.save(driver);
    }

    public Driver findDriverById(long id) {
        return driverRepository.findById(id);
    }

    public List<Driver> getDriversByStatus(DriverStatus driverStatus) {
        return driverRepository.findByStatus(driverStatus);
    }



//    @Scheduled(fixedRate = 30000, initialDelay = 20000)
//    @Transactional
//    public void scheduleTask() {
//        driverRepository.updateDriver();
//        System.out.println("Траляля");
//    }
}


