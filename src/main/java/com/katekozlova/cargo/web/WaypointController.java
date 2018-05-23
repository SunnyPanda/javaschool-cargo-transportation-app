package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.CitiesService;
import com.katekozlova.cargo.business.service.WaypointService;
import com.katekozlova.cargo.data.entity.Cargo;
import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.entity.WaypointType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/waypoints")
public class WaypointController {

    private final WaypointService waypointService;
    private final CitiesService citiesService;
    private final CargoService cargoService;

    @Autowired
    public WaypointController(WaypointService waypointService, CitiesService citiesService, CargoService cargoService) {
        this.waypointService = waypointService;
        this.citiesService = citiesService;
        this.cargoService = cargoService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Waypoint> waypoints = waypointService.getAllWaypoints();
        return new ModelAndView("waypoints/list", "waypoints", waypoints);
    }

    @GetMapping(value = {"/create"})
    public String newWaypoint(ModelMap model) {
        Waypoint waypoint = new Waypoint();
        final List<City> cities = citiesService.getAllCities();
        final List<Cargo> cargo = cargoService.getAllCargo();
        model.addAttribute("waypoint", waypoint);
        model.addAttribute("waypointType", WaypointType.values());
        model.addAttribute("cities", cities);
        model.addAttribute("cargo", cargo);
        return "waypoints/create";
    }
}
