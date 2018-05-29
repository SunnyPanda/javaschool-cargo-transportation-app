package com.katekozlova.cargo.business.service;


import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.DriverStatus;
import com.katekozlova.cargo.data.repository.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriversService {

    static final Logger logger = LoggerFactory.getLogger(DriversService.class);

    private final DriverRepository driverRepository;

    @Autowired
    public DriversService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return Lists.newArrayList(driverRepository.findAll());
    }

    public void deleteDriver(Driver driver) {
        Driver tempDriver = driver;
        driverRepository.delete(driver);
        logger.info("driver was deleted: {}", tempDriver);
    }

    public Driver updateDriver(Driver driver) {
        logger.error("driver: {}", driver);
        driver = driverRepository.save(driver);
        logger.info("driver was updated: {}", driver);
        return driver;
    }

    public Driver createDriver(Driver driver) {
        driver.setDriverStatus(DriverStatus.REST);
        driver = driverRepository.save(driver);
        logger.info("new driver was created: {}", driver);
        return driver;
    }

    public Driver findDriverById(long id) {
        return driverRepository.findById(id);
    }

    public List<Driver> getDriversByStatus(DriverStatus driverStatus) {
        return driverRepository.findByStatus(driverStatus);
    }


    @Scheduled(fixedRate = 30000, initialDelay = 20000)
    //@Scheduled(cron = " 0,59 59 23 L * ? *")
    @Transactional
    public void scheduleTask() {
        driverRepository.updateHoursPerMonth();
        logger.error("Updated!");
    }
}


