package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrucksService {

    private TruckRepository truckRepository;

    @Autowired
    public TrucksService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<Truck> getAllTrucks() {
        return Lists.newArrayList(truckRepository.findAll());
    }

    public void deleteTruck(Truck truck) {
        truckRepository.delete(truck);
    }

    public Truck createAndUpdate(Truck truck) {
        return truckRepository.save(truck);
    }

    public Truck findById(long id) {
        return truckRepository.findById(id);
    }
}
