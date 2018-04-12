package com.katekozlova.cargo.business.service;


import com.katekozlova.cargo.business.domain.ListOfDrivers;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriversService {

    ///dfgrt
    @Autowired
    private DriverRepository driverRepository;

//    @Autowired
//    public DriversService(DriverRepository driverRepository) {
//        this.driverRepository = driverRepository;
//    }

    public List<ListOfDrivers> getAllDrivers() {
        Iterable<Driver> drivers = this.driverRepository.findAll();
        System.out.println("drivers = " + drivers);
        List<ListOfDrivers> listOfDrivers = new ArrayList<>();
        drivers.forEach(dr->{
            ListOfDrivers driver = new ListOfDrivers();
            driver.setDriverId(dr.getId());
            driver.setPersonalNumber(dr.getPersonalNumber());
            driver.setFirstName(dr.getFirstName());
            driver.setLastName(dr.getLastName());
            listOfDrivers.add(driver);
        });

        return listOfDrivers;
    }
}


