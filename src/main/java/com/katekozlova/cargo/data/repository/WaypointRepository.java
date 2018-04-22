package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.entity.WaypointType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaypointRepository extends CrudRepository<Waypoint, Long> {

    List<Waypoint> findByOrderId(Long orderId);

    List<Waypoint> findWaypointsByOrderIsNull();

    // Waypoint findWaypointsByCargoIdAndWaypointTypeAndOrderId(long cargoId, WaypointType waypointType, long orderId);
    Waypoint findWaypointByOrderIdAndCargoIdAndWaypointType(Long orderId, long cargoId, WaypointType waypointType);

    List<Waypoint> findWaypointsByOrderIdAndWaypointType(long id, WaypointType waypointType);
}
