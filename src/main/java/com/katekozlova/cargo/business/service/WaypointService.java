package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
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
    private final CargoService cargoService;

    @Autowired
    public WaypointService(WaypointRepository waypointRepository, CargoService cargoService) {
        this.waypointRepository = waypointRepository;
        this.cargoService = cargoService;
    }

    public List<Waypoint> getAllWaypoints() {
        return Lists.newArrayList(waypointRepository.findAll());
    }

    public List<Waypoint> findFreeWaypoints() {
        return waypointRepository.findWaypointsByNullOrder();
    }

    public Waypoint createWaypoint(Waypoint waypoint) {
//        waypoint.getCargo().setBookingStatus(BookingStatus.YES);
//        cargoService.saveCargo(waypoint.getCargo());
        return waypointRepository.save(waypoint);
    }
}
