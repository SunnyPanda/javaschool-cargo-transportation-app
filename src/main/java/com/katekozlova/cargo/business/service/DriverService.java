package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.DriverStatus;
import com.katekozlova.cargo.data.entity.OrderStatus;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Hours;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DriverService {

    private static final Logger logger = LoggerFactory.getLogger(DriverService.class);

    private final DriverRepository driverRepository;
    private final OrderRepository orderRepository;
    private final TruckRepository truckRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository, OrderRepository orderRepository, TruckRepository truckRepository) {
        this.driverRepository = driverRepository;
        this.orderRepository = orderRepository;
        this.truckRepository = truckRepository;
    }

    public void setShiftBeginTime(Driver driver) {

        driver.setShiftBegin(new DateTime());
        driver.setDriverStatus(DriverStatus.IN_SHIFT);
        driverRepository.save(driver);
        logger.info("driver was changed(set driverStatus): {}", driver);
    }

    public void setShiftEnd(Driver driver) {
        final DateTime shiftEnd = new DateTime();
        DateTime firstDayOfMonth = shiftEnd.dayOfMonth().withMinimumValue();
        final long hoursBetween;
        if (DateTimeComparator.getDateOnlyInstance().compare(firstDayOfMonth, driver.getShiftBegin()) < 0) {
            hoursBetween = Hours.hoursBetween(driver.getShiftBegin(), shiftEnd).getHours();
            driver.setHoursPerMonth(driver.getHoursPerMonth() + hoursBetween);
            logger.error("Hours per month: {}", driver.getHoursPerMonth());
        } else {
            hoursBetween = Hours.hoursBetween(firstDayOfMonth, shiftEnd).getHours();
            driver.setHoursPerMonth(hoursBetween);
        }
        driver.setDriverStatus(DriverStatus.REST);
        driver.getOrder().setOrderStatus(OrderStatus.YES);
        orderRepository.save(driver.getOrder());
        driver.setOrder(null);
        logger.info("driver was changed(set driverStatus), order: {}", driver.getOrder());
        driver.getCurrentTruck().setOrder(null);
        driver.getCurrentTruck().setDrivers(null);
        truckRepository.save(driver.getCurrentTruck());
        logger.info("driver was changed(set driverStatus), truck: {}", driver.getCurrentTruck());
        driver.setCurrentTruck(null);
        driverRepository.save(driver);

        logger.info("driver was changed(set driverStatus), driver: {}", driver);
    }

    public List<Driver> findByTruck(long id) {

        List<Driver> drivers = driverRepository.findByCurrentTruck(driverRepository
                .findById(id).getCurrentTruck());
        return drivers.stream().filter(driver -> driver.getId() != id).collect(Collectors.toList());
    }
}
