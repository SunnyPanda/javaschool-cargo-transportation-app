package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.CargoRepository;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoService {

    private final CargoRepository cargoRepository;
    private final WaypointRepository waypointRepository;

    @Autowired
    public CargoService(CargoRepository cargoRepository, WaypointRepository waypointRepository) {
        this.cargoRepository = cargoRepository;
        this.waypointRepository = waypointRepository;
    }

    public List<Cargo> getAllCargo() {
        return cargoRepository.findAll();
    }

    public Cargo getCargoByNumber(long cargoNumber) {
        return cargoRepository.findByNumber(cargoNumber);
    }

    public void setCargoStatus(long cargoId, CargoStatus cargoStatus) {
        Cargo cargo = cargoRepository.findById(cargoId);
        cargo.setCargoStatus(cargoStatus);
        cargoRepository.save(cargo);
    }

    public List<Cargo> getFreeCargo() {
        return cargoRepository.findByNullOrder();
    }

    public List<Waypoint> getCargoByWaypoints(long orderId) {
        return waypointRepository.findWaypointsByOrderWaypointType(orderId, WaypointType.SHIPMENT);
    }
}
