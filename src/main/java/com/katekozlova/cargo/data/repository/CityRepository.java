package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
