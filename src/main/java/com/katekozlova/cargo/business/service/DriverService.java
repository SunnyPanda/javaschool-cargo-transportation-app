package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.joda.time.DateTime;
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

    static final Logger logger = LoggerFactory.getLogger(DriverService.class);

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
        logger.info("driver was changed(set driverStatus): {}" + driver);
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
        driver.setHoursPerMonth(driver.getHoursPerMonth() + 50);
        driver.setDriverStatus(DriverStatus.REST);
        driver.getOrder().setOrderStatus(OrderStatus.YES);
        driver.getOrder().setTruck(null);
        orderRepository.save(driver.getOrder());
        driver.setOrder(null);
        logger.info("driver was changed(set driverStatus): {}", driver.getOrder());
        driver.getCurrentTruck().setOrder(null);
        driver.getCurrentTruck().setDrivers(null);
        truckRepository.save(driver.getCurrentTruck());
        logger.info("driver was changed(set driverStatus): {}", driver.getCurrentTruck());
        driver.setCurrentTruck(null);
        driverRepository.save(driver);

        logger.info("driver was changed(set driverStatus): {}", driver);
    }

    public List<Driver> findByTruck(long id) {

        List<Driver> drivers = driverRepository.findByCurrentTruck(driverRepository
                .findById(id).getCurrentTruck());
        return drivers.stream().filter(driver -> driver.getId() != id).collect(Collectors.toList());
    }
}
