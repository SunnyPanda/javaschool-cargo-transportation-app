package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.entity.TruckState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckRepository extends CrudRepository<Truck, Long> {

    List<Truck> findTrucksByTruckStateAndOrderIsNull(TruckState truckState);

    Truck findTruckById(Long id);
}
