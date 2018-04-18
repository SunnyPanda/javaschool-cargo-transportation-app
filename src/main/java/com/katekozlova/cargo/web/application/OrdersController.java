package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.service.DriversService;
import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.business.service.WaypointService;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.entity.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    private final OrderService orderService;
    private final DriversService driversService;
    private final WaypointService waypointService;

    @Autowired
    public OrdersController(OrderService orderService, DriversService driversService, WaypointService waypointService) {
        this.orderService = orderService;
        this.driversService = driversService;
        this.waypointService = waypointService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Order> orders = orderService.getAllOrders();
        return new ModelAndView("orders/list", "orders", orders);
    }

    @GetMapping(value = "/waypoints/{id}")
    public ModelAndView getWaypoints(@PathVariable("id") long id) {
        List<Waypoint> waypoints = orderService.getOrderWaypoints(id);
        return new ModelAndView("orders/waypoints", "waypoints", waypoints);
    }

    @GetMapping(value = "/drivers/{id}")
    public ModelAndView getDrivers(@PathVariable("id") long id) {
        List<Driver> drivers = orderService.getOrdersDrivers(id);
        return new ModelAndView("orders/drivers", "drivers", drivers);
    }

    @GetMapping(value = "/{id}/trucks")
    public ModelAndView getTrucks(@PathVariable("id") long id, Model model) {
        List<Truck> trucks = orderService.getTrucks(id);
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return new ModelAndView("orders/trucks", "trucks", trucks);
    }

    @GetMapping(value = "/{id1}/trucks/add/{id2}")
    public String addTruck(@PathVariable("id1") long orderId, @PathVariable("id2") long truckId) {
        orderService.addTruckToOrder(orderId, truckId);
        return "redirect:/orders/list";
    }

    @GetMapping(value = "/create/step1")
    public String createOrder(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "orders/create/step1";
    }

//    @PostMapping(value = "/create/step1")
//    public String saveNumber(Order order) {
//    orderService.create(order);
//    return "create/waypoint";
//    }

//    @GetMapping(value = "/create/waypoint")
//    public String createWaypoint(Model model) {
//        return
//    }
//    @GetMapping(value = "/create")
//    public String newOrder(ModelMap model) {
//        Order order = new Order();
//        List<Waypoint> waypoints = waypointService.findFreeWaypoints();
//        model.addAttribute("waypoints", waypoints);
//        model.addAttribute("order", order);
//        model.addAttribute("statusValues", OrderStatus.values());
//        return "orders/create";
//    }
//
//    @PostMapping(value = "/create")
//    public String createOrder(Order order) {
//        orderService.create(order);
//        return "redirect:/orders/list";
//    }

    @GetMapping(value = "/status")
    public ModelAndView getStatus() {
        List<Order> orders = orderService.getAllOrders();
        return new ModelAndView("orders/status", "orders", orders);
    }


}
