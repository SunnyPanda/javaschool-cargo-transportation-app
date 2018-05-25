package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WaypointService {

    private final WaypointRepository waypointRepository;

    @Autowired
    public WaypointService(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    public List<Waypoint> getAllWaypoints() {
        return waypointRepository.findAll();
    }

    public Waypoint createWaypoint(Waypoint waypoint) {
        return waypointRepository.save(waypoint);
    }
}
