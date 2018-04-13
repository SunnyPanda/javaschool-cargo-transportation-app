package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends CrudRepository<Truck, Long> {

}
