package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaypointService {

    private final WaypointRepository waypointRepository;

    @Autowired
    public WaypointService(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    public List<Waypoint> getAllWaypoints() {
        return Lists.newArrayList(waypointRepository.findAll());
    }

    public List<Waypoint> findFreeWaypoints() {
        return waypointRepository.findWaypointsByOrderIsNull();
    }
}
