package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.Cargo;
import com.katekozlova.cargo.data.entity.CargoStatus;
import com.katekozlova.cargo.data.repository.CargoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoService {

    static final Logger logger = LoggerFactory.getLogger(CargoService.class);

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

    public void setCargoStatus(long cargoId, CargoStatus cargoStatus) {
        Cargo cargo = cargoRepository.findById(cargoId);
        cargo.setCargoStatus(cargoStatus);
        cargoRepository.save(cargo);
        logger.info("cargo was changed(set cargoStatus): {}", cargo);
    }

    public List<Cargo> getFreeCargo() {
        return cargoRepository.findByNullOrder();
    }

}
