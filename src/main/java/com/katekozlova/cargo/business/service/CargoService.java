package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.BookingStatus;
import com.katekozlova.cargo.data.entity.Cargo;
import com.katekozlova.cargo.data.entity.CargoStatus;
import com.katekozlova.cargo.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<Cargo> getAllCargo() {
        return cargoRepository.findAll();
    }

    public Cargo getCargoByNumber(long cargoNumber) {
        return cargoRepository.findByNumber(cargoNumber);
    }

    public Cargo getCargoById(long cargoId) {
        return cargoRepository.findById(cargoId);
    }

    public void setCargoStatus(long cargoId, CargoStatus cargoStatus) {
        Cargo cargo = cargoRepository.findById(cargoId);
        cargo.setCargoStatus(cargoStatus);
        cargoRepository.save(cargo);
    }

    public List<Cargo> getFreeCargo() {
        return cargoRepository.findByNullOrder();
    }
}
