package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.entity.MapDistance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapDistanceRepository extends CrudRepository<MapDistance, Long> {

    MapDistance findMapDistanceByCityFromAndCityTo(City city1, City city2);
}
