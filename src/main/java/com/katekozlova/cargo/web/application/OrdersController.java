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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
@SessionAttributes("order")
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

    @PostMapping(value = "/create/waypoint")
    public String saveNumber(Order order, Model model) {
        orderService.create(order);
        List<Waypoint> waypoints = waypointService.findFreeWaypoints();
        model.addAttribute("order", order);
        model.addAttribute("freewaypoints", waypoints);
        return "orders/create/waypoint";
    }

    @PostMapping(value = "/save")
    public String saveWaypoint(Order order, Model model) {
        System.out.println ( "До сохранения" );
        for ( Waypoint waypoint : order.getWaypoints ( ) ) {
            System.out.println ( "waypoint.getId() = " + waypoint.getId ( ) );
        }
        orderService.saveWaipoints ( order );
        List<Waypoint> freeWaypoints = waypointService.findFreeWaypoints ( );
        model.addAttribute ( "order", order );
        model.addAttribute ( "freewaypoints", freeWaypoints );
        return "orders/create/waypoint";
    }

    @PostMapping(value = "/addtruck")
    public String addTruck(Order order, Model model) {
        List<Truck> trucks = orderService.getTrucks ( order.getId ( ) );
        model.addAttribute ( "order", order );
        model.addAttribute ( "trucks", trucks );
        return "orders/create/truck";
    }

    @PostMapping(value = "/savetruck")
    public String saveTruck(Order order, Model model) {
        orderService.saveTruckToOrder ( order );
        List<Truck> trucks = orderService.getTrucks ( order.getId ( ) );
        model.addAttribute ( "order", order );
        model.addAttribute ( "trucks", trucks );
        return "orders/create/truck";
    }

    @PostMapping(value = "/adddriver")
    public String addDriver(Order order, Model model) {
        List<Driver> drivers = orderService.getDrivers ( order );
        model.addAttribute ( "order", order );
        model.addAttribute ( "drivers", drivers );
        return "orders/create/driver";
    }

    @PostMapping(value = "/savedriver")
    public String saveDriver(Order order, Model model) {
        orderService.saveDriversToOrder ( order );
        List<Driver> drivers = orderService.getDrivers ( order );
        model.addAttribute ( "order", order );
        model.addAttribute ( "drivers", drivers );
        return "orders/create/driver";
    }
//    @GetMapping(value = "/create/waypoint")
//    public String createWaypoint(Model model) {
//        return "orders/list";
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
