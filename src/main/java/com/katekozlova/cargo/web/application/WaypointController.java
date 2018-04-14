package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.service.WaypointService;
import com.katekozlova.cargo.data.entity.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/waypoints")
public class WaypointController {

    private final WaypointService waypointService;

    @Autowired
    public WaypointController(WaypointService waypointService) {
        this.waypointService = waypointService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Waypoint> waypoints = waypointService.getAllWaypoints();
        return new ModelAndView("waypoints/list", "waypoints", waypoints);
    }
}
