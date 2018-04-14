package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Waypoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaypointRepository extends CrudRepository<Waypoint, Long> {
}
