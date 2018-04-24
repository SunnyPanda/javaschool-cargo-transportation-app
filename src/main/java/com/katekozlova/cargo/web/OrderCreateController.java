package com.katekozlova.cargo.web;


import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.business.service.WaypointService;
import com.katekozlova.cargo.business.validation.OrderValidator;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.entity.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
@SessionAttributes("order")
public class OrderCreateController {

    private final OrderService orderService;
    private final WaypointService waypointService;
    private final OrderValidator orderValidator;

    @Autowired
    public OrderCreateController(OrderService orderService, WaypointService waypointService, OrderValidator orderValidator) {
        this.orderService = orderService;
        this.waypointService = waypointService;
        this.orderValidator = orderValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(orderValidator);
    }

    @GetMapping(value = "/create/step1")
    public String createOrder(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "orders/create/step1";
    }

    @PostMapping(value = "/create/waypoint")
    public String saveNumber(Order order, Model model) {
        orderService.create(order);
        List<Waypoint> waypoints = waypointService.findFreeWaypoints();
        model.addAttribute("order", order);
        model.addAttribute("freewaypoints", waypoints);
        return "orders/create/waypoint";
    }

    @PostMapping(value = "/save")
    public String saveWaypoint(@Validated Order order, BindingResult bindingResult, Model model) {
        orderService.saveWaipoints(order);
        if (bindingResult.hasErrors()) {
            System.out.println("Произошла ошибка");
            return "orders/create/waypoint";
        }
        System.out.println("order = " + order);
        List<Waypoint> freeWaypoints = waypointService.findFreeWaypoints();
        model.addAttribute("order", order);
        model.addAttribute("freewaypoints", freeWaypoints);
        return "orders/create/waypoint";
    }

    @PostMapping(value = "/addtruck")
    public String addTruck(Order order, Model model) {
        List<Truck> trucks = orderService.getTrucks(order.getId());
        model.addAttribute("order", order);
        model.addAttribute("trucks", trucks);
        return "orders/create/truck";
    }

    @PostMapping(value = "/savetruck")
    public String saveTruck(Order order, Model model) {
        orderService.saveTruckToOrder(order);
        System.out.println("order = " + order);
        List<Truck> trucks = orderService.getTrucks(order.getId());
        model.addAttribute("order", order);
        model.addAttribute("trucks", trucks);
        return "orders/create/truck";
    }

    @PostMapping(value = "/adddriver")
    public String addDriver(Order order, Model model) {
        List<Driver> drivers = orderService.getDrivers(order);
        model.addAttribute("order", order);
        model.addAttribute("drivers", drivers);
        return "orders/create/driver";
    }

    @PostMapping(value = "/savedriver")
    public String saveDriver(Order order, Model model) {
        orderService.saveDriversToOrder(order);
        System.out.println("order = " + order);
        List<Driver> drivers = orderService.getDrivers(order);
        model.addAttribute("order", order);
        model.addAttribute("drivers", drivers);
        return "orders/create/driver";
    }
}
