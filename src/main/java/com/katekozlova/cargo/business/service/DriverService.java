package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.DriverStatus;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.repository.DriverRepository;
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
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void setShiftBeginTime(Driver driver) {

        driver.setShiftBegin(new DateTime());
        driver.setDriverStatus(DriverStatus.IN_SHIFT);
        driverRepository.save(driver);
        System.out.println("driver.getShiftBegin() = " + driver.getShiftBegin());
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
        driverRepository.save(driver);
    }

    public List<Driver> findByTruck(long id) {

        List<Driver> drivers = driverRepository.findByCurrentTruck(driverRepository
                .findById(id).getCurrentTruck());
        return drivers.stream().filter(driver -> driver.getId() != id).collect(Collectors.toList());
    }
}
