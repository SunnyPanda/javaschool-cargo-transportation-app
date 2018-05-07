package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.entity.TruckState;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrucksService {

    private final TruckRepository truckRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public TrucksService(TruckRepository truckRepository, DriverRepository driverRepository) {
        this.truckRepository = truckRepository;
        this.driverRepository = driverRepository;
    }

    public List<Truck> getAllTrucks() {
        return Lists.newArrayList(truckRepository.findAll());
    }

    public void deleteTruck(Truck truck) {

        truck.setDrivers(driverRepository.findByCurrentTruck(truck));
        if (!driverRepository.findByCurrentTruck(truck).isEmpty()) {
            for (Driver driver : truck.getDrivers()) {
                driver.setCurrentTruck(null);
            }
        }
        truckRepository.delete(truck);
    }

    public Truck createAndUpdate(Truck truck) {
        return truckRepository.save(truck);
    }

    public Truck findById(long id) {
        return truckRepository.findById(id);
    }

    public List<Truck> getTrucksByState(TruckState truckState) {
        return truckRepository.findByState(truckState);
    }

    public List<Truck> getTrucksWithOrder() {
        return truckRepository.findByOrder();
    }

    public List<Truck> availableTrucks(TruckState truckState) {
        return truckRepository.findByOrderTruckState(truckState);
    }
}
