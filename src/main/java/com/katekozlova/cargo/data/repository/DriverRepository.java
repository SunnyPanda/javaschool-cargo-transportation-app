package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {

    List<Driver> findDriverByOrderId(Long id);

    Driver findDriverById(Long id);

    List<Driver> findDriverByCurrentTruck(Truck truck);

    List<Driver> findDriverByOrderIsNullAndCurrentCityId(Long id);
}
