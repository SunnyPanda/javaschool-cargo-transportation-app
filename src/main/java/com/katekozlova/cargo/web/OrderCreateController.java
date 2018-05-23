package com.katekozlova.cargo.web;


import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.CitiesService;
import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.business.service.WaypointService;
import com.katekozlova.cargo.business.validation.OrderValidator;
import com.katekozlova.cargo.data.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(orderValidator);
//    }

    @GetMapping(value = "/create/number")
    public String createOrder(Model model) {
        Order order = new Order();
        logger.trace("Entering application.");
        //System.out.println("1. order = " + order);
        model.addAttribute("order", order);
        return "orders/create/step1";
    }

    @GetMapping(value = "/create/waypoint")
    public String createWaypoints(Order order, Model model) {
        //orderService.create(order);
        //List<Waypoint> waypoints = waypointService.findFreeWaypoints();
        System.out.println("2. order = " + order);
        Waypoint waypoint = new Waypoint();
        final List<City> cities = citiesService.getAllCities();
        final List<Cargo> cargo = cargoService.getCargoByBookingStatus(BookingStatus.NO);
        //model.addAttribute("order", order);
        model.addAttribute("waypoint", waypoint);
        model.addAttribute("city", cities);
        model.addAttribute("cargo", cargo);
        model.addAttribute("waypointType", WaypointType.values());
        //model.addAttribute("freewaypoints", waypoints);
        return "orders/create/waypoint";
    }

    @PostMapping(value = "/save")
    public String saveWaypoint(@Validated Order order, Waypoint waypoint, BindingResult bindingResult, Model model) {
        System.out.println("order = [" + order + "], waypoint = [" + waypoint + "], bindingResult = [" + bindingResult + "], model = [" + model + "]");
        System.out.println("1. waypoint = " + waypoint);
        waypoint = waypointService.createWaypoint(waypoint);
        System.out.println("2. waypoint = " + waypoint);
        orderService.saveWaipoints(order, waypoint);
//        if (bindingResult.hasErrors()) {
//            System.out.println("Произошла ошибка");
//            return "orders/create/waypoint";
//        }
        System.out.println("4. order = " + order);
        final List<City> cities = citiesService.getAllCities();
        final List<Cargo> cargo = cargoService.getCargoByBookingStatus(BookingStatus.NO);
        //model.addAttribute("order", order);
        model.addAttribute("waypoint", waypoint);
        model.addAttribute("city", cities);
        model.addAttribute("cargo", cargo);
        model.addAttribute("waypointType", WaypointType.values());
//        List<Waypoint> freeWaypoints = waypointService.findFreeWaypoints();
//        model.addAttribute("order", order);
//        model.addAttribute("freewaypoints", freeWaypoints);
        return "orders/create/waypoint";
    }

    @GetMapping(value = "/addtruck")
    public String addTruck(Order order, Model model) {
        List<Truck> trucks = orderService.getTrucks(order);
        model.addAttribute("order", order);
        model.addAttribute("trucks", trucks);
        return "orders/create/truck";
    }

    @PostMapping(value = "/savetruck")
    public String saveTruck(Order order, Model model) {
        //orderService.saveTruckToOrder(order);
        System.out.println("order = " + order);
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
        //orderService.saveDriversToOrder(order);
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
