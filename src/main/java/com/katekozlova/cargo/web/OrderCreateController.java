package com.katekozlova.cargo.web;


import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.CitiesService;
import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.business.service.WaypointService;
import com.katekozlova.cargo.business.validation.OrderValidator;
import com.katekozlova.cargo.data.entity.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/orders")
@SessionAttributes(names = {"order"})
public class OrderCreateController {

    private final OrderService orderService;
    private final WaypointService waypointService;
    private final OrderValidator orderValidator;
    private final AmqpTemplate amqpTemplate;
    private static final Logger logger = LogManager.getLogger(OrderCreateController.class);
    private final CitiesService citiesService;
    private final CargoService cargoService;

    @Autowired
    public OrderCreateController(OrderService orderService, WaypointService waypointService, OrderValidator orderValidator,
                                 AmqpTemplate amqpTemplate, CitiesService citiesService, CargoService cargoService) {
        this.orderService = orderService;
        this.waypointService = waypointService;
        this.orderValidator = orderValidator;
        this.amqpTemplate = amqpTemplate;
        this.citiesService = citiesService;
        this.cargoService = cargoService;
    }

    @InitBinder("order")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(orderValidator);
    }

    @GetMapping(value = "/create/number")
    public String createOrder(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "orders/create/step1";
    }

    @GetMapping(value = "/create/waypoint")
    public String createWaypoints(Model model) {
        Waypoint waypoint = new Waypoint();
        final List<City> cities = citiesService.getAllCities();
        final List<Cargo> cargo = cargoService.getFreeCargo();
        model.addAttribute("waypoint", waypoint);
        model.addAttribute("city", cities);
        model.addAttribute("cargo", cargo);
        model.addAttribute("waypointType", WaypointType.values());
        return "orders/create/waypoint";
    }

    @PostMapping(value = "/create/waypoint")
    public String saveWaypoint(Order order, Waypoint waypoint, Model model) {
        waypoint = waypointService.createWaypoint(waypoint);
        orderService.saveWaipoints(order, waypoint);

        final List<City> cities = citiesService.getAllCities();
        final List<Cargo> cargo = cargoService.getFreeCargo();
        model.addAttribute("order", order);
        model.addAttribute("waypoint", waypoint);
        model.addAttribute("city", cities);
        model.addAttribute("cargo", cargo);
        model.addAttribute("waypointType", WaypointType.values());
        return "orders/create/waypoint";
    }

    @GetMapping(value = "/addtruck")
    public String addTruck(@Validated Order order, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            final List<City> cities = citiesService.getAllCities();
            final List<Cargo> cargo = cargoService.getFreeCargo();
            model.addAttribute("order", order);
            model.addAttribute("waypoint", new Waypoint());
            model.addAttribute("city", cities);
            model.addAttribute("cargo", cargo);
            model.addAttribute("waypointType", WaypointType.values());
            System.out.println("Error!");
            return "orders/create/waypoint";
        }
        List<Truck> trucks = orderService.getTrucks(order);
        model.addAttribute("order", order);
        model.addAttribute("trucks", trucks);
        return "orders/create/truck";
    }

    @PostMapping(value = "/savetruck")
    public String saveTruck(Order order, Model model) {
        List<Truck> trucks = orderService.getTrucks(order);
        model.addAttribute("order", order);
        model.addAttribute("trucks", trucks);
        return "orders/create/truck";
    }

    @GetMapping(value = "/adddriver")
    public String addDriver(Order order, Model model) {
        List<Driver> drivers = orderService.getDrivers(order);
        model.addAttribute("order", order);
        model.addAttribute("drivers", drivers);
        return "orders/create/driver";
    }

    @PostMapping(value = "/savedriver")
    public String saveDriver(Order order, Model model) {
        System.out.println("order = " + order);
        List<Driver> drivers = orderService.getDrivers(order);
        model.addAttribute("order", order);
        model.addAttribute("drivers", drivers);
        return "orders/create/driver";
    }

    @GetMapping(value = "/save")
    public String saveOrder(Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders/list";
    }

    @GetMapping(value = "/preview")
    public String preview(Order order, Model model) {
        model.addAttribute("order", order);
        return "orders/create/preview";
    }

    @GetMapping(value = "/waypoints")
    public ModelAndView getWaypoints(Order order) {
        return new ModelAndView("orders/waypoints", "waypoints", order.getWaypoints());
    }

    @GetMapping(value = "/drivers")
    public ModelAndView getDrivers(Order order) {
        return new ModelAndView("orders/drivers", "drivers", order.getDrivers());
    }
}
