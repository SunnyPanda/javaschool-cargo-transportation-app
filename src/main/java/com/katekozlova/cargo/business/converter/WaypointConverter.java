package com.katekozlova.cargo.business.converter;

import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WaypointConverter implements Converter<String, Waypoint> {

    private final WaypointRepository waypointRepository;

    @Autowired
    public WaypointConverter(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    @Override
    public Waypoint convert(String id) {
        return waypointRepository.findById(Long.parseLong(id));
    }
}
