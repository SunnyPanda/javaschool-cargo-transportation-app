package com.katekozlova.cargo.web;


import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.CitiesService;
import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.business.service.WaypointService;
import com.katekozlova.cargo.business.validation.OrderValidator;
import com.katekozlova.cargo.data.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/manager/orders")
@SessionAttributes(names = {"order"})
public class OrderCreateController {

    static final Logger logger = LoggerFactory.getLogger(OrderCreateController.class);

    private final OrderService orderService;
    private final WaypointService waypointService;
    private final CitiesService citiesService;
    private final CargoService cargoService;

    private final OrderValidator orderValidator;

    private final AmqpTemplate amqpTemplate;

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
        logger.error("orderValidator");
        binder.addValidators(orderValidator);
    }


    @GetMapping(value = "/create/number")
    public String createOrder(@Validated Order order, Model model, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors("drivers")) {
            List<Driver> drivers = orderService.getDrivers(order);
            model.addAttribute("order", order);
            model.addAttribute("drivers", drivers);
            return "orders/create/driver";
        }
        model.addAttribute("order", order);
        return "orders/create/step1";
    }

    @GetMapping(value = "/create/waypoint")
    public String createWaypoints(Model model) {
        Order order = new Order();
        Waypoint waypoint = new Waypoint();
        final List<City> cities = citiesService.getAllCities();
        final List<Cargo> cargo = cargoService.getFreeCargo();
        model.addAttribute("order", order);
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
        if (bindingResult.hasFieldErrors("waypoints")) {
            final List<City> cities = citiesService.getAllCities();
            final List<Cargo> cargo = cargoService.getFreeCargo();
            model.addAttribute("order", order);
            model.addAttribute("waypoint", new Waypoint());
            model.addAttribute("city", cities);
            model.addAttribute("cargo", cargo);
            model.addAttribute("waypointType", WaypointType.values());
            logger.error("Error!");
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
    public String addDriver(@Validated Order order, Model model, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors("truck")) {
            logger.error("error occurred");
            List<Truck> trucks = orderService.getTrucks(order);
            model.addAttribute("order", order);
            model.addAttribute("trucks", trucks);
           return  "orders/create/truck";
        }
        List<Driver> drivers = orderService.getDrivers(order);
        model.addAttribute("order", order);
        model.addAttribute("drivers", drivers);
        return "orders/create/driver";
    }

    @PostMapping(value = "/savedriver")
    public String saveDriver(@Validated Order order, Model model, BindingResult bindingResult) {
//        List<Driver> drivers = orderService.getDrivers(order);
//        if (bindingResult.hasFieldErrors("drivers")) {
//            model.addAttribute("order", order);
//            model.addAttribute("drivers", drivers);
//            return "orders/create/driver";
//        }
        List<Driver> drivers = orderService.getDrivers(order);
        model.addAttribute("order", order);
        model.addAttribute("drivers", drivers);
        return "orders/create/driver";
    }

    @PostMapping(value = "/save")
    public String saveOrder(Order order) {
        orderService.saveOrder(order);
        amqpTemplate.convertAndSend("queue", "order");
        amqpTemplate.convertAndSend("queue", "driver");
        amqpTemplate.convertAndSend("queue", "truck");
        return "redirect:/manager/orders/list";
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
