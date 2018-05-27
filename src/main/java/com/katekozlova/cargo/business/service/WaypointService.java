package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.entity.WaypointType;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WaypointService {

    static final Logger logger = LoggerFactory.getLogger(WaypointService.class);

    private final WaypointRepository waypointRepository;

    @Autowired
    public WaypointService(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    public List<Waypoint> getAllWaypoints() {
        return waypointRepository.findAll();
    }

    public Waypoint createWaypoint(Waypoint waypoint) {
        waypoint = waypointRepository.save(waypoint);
        logger.info("new waypoint was created: {}", waypoint);
        return waypoint;
    }

    public List<Waypoint> getCargoByWaypoints(long orderId) {
        return waypointRepository.findWaypointsByOrderWaypointType(orderId, WaypointType.SHIPMENT);
    }
}
