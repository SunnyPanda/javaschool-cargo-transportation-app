package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.Cargo;
import com.katekozlova.cargo.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<Cargo> getAllCargo() {
        return cargoRepository.findAll();
    }

    public Cargo getByNumber(long cargoNumber) {
        return cargoRepository.findCargoByNumber(cargoNumber);
    }
}
