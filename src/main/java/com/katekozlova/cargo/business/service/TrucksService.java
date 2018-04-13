package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.business.domain.ListOfTrucks;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrucksService {

    @Autowired
    private TruckRepository truckRepository;

    public List<ListOfTrucks> getAllDrivers() {
        Iterable<Truck> drivers = this.truckRepository.findAll();
        System.out.println("drivers = " + drivers);
        List<ListOfTrucks> listOfTrucks = new ArrayList<>();
        drivers.forEach(tr -> {
            ListOfTrucks truck = new ListOfTrucks();
            truck.setTruckId(tr.getId());
            truck.setRegNumber(tr.getRegNumber());
            truck.setShiftSize(tr.getShiftSize());
            truck.setCapacity(tr.getCapacity());
            listOfTrucks.add(truck);
        });

        return listOfTrucks;
    }
}
