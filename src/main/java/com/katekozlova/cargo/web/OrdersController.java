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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
//@SessionAttributes("order")
public class OrdersController {

    private final OrderService orderService;
    private final WaypointService waypointService;
    private final OrderValidator orderValidator;


    @Autowired
    public OrdersController(OrderService orderService, WaypointService waypointService, OrderValidator orderValidator) {
        this.orderService = orderService;
        this.waypointService = waypointService;
        this.orderValidator = orderValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(orderValidator);
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Order> orders = orderService.getAllOrders();
        orderService.setExistingOrdersTravelTime();
        return new ModelAndView("orders/list", "orders", orders);
    }

    @GetMapping(value = "/waypoints/{id}")
    public ModelAndView getWaypoints(@PathVariable("id") long id) {
        List<Waypoint> waypoints = orderService.getOrderWaypoints(id);
        return new ModelAndView("orders/waypoints", "waypoints", waypoints);
    }

    @GetMapping(value = "/drivers/{id}")
    public ModelAndView getDriversToOrder(@PathVariable("id") long id) {
        List<Driver> drivers = orderService.getOrdersDrivers(id);
        return new ModelAndView("orders/drivers", "drivers", drivers);
    }

    @GetMapping(value = "/{id}/trucks")
    public ModelAndView getTrucks(@PathVariable("id") long id, Model model) {
        List<Truck> trucks = orderService.getTrucks(orderService.findById(id));
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return new ModelAndView("orders/trucks", "trucks", trucks);
    }

//    @GetMapping(value = "/{id1}/trucks/add/{id2}")
//    public String addTruck(@PathVariable("id1") long orderId, @PathVariable("id2") long truckId) {
//        orderService.addTruckToOrder(orderId, truckId);
//        return "redirect:/orders/list";
//    }
//**********
//    @GetMapping(value = "/create/step1")
//    public String createOrder(Model model) {
//        Order order = new Order();
//        model.addAttribute("order", order);
//        return "orders/create/step1";
//    }

//    @PostMapping(value = "/create/waypoint")
//    public String saveNumber(Order order, Model model) {
//        orderService.create(order);
//        List<Waypoint> waypoints = waypointService.findFreeWaypoints();
//        model.addAttribute("order", order);
//        model.addAttribute("freewaypoints", waypoints);
//        return "orders/create/waypoint";
//    }

//    @PostMapping(value = "/save")
//    public String saveWaypoint(@Validated Order order, BindingResult bindingResult, Model model) {
//        orderService.saveWaipoints ( order );
//        if (bindingResult.hasErrors()) {
//            System.out.println("Произошла ошибка");
//            return "orders/create/waypoint";
//        }
//        System.out.println("order = " + order);
//        List<Waypoint> freeWaypoints = waypointService.findFreeWaypoints ( );
//        model.addAttribute ( "order", order );
//        model.addAttribute ( "freewaypoints", freeWaypoints );
//        return "orders/create/waypoint";
//    }

//    @PostMapping(value = "/addtruck")
//    public String addTruck(Order order, Model model) {
//        List<Truck> trucks = orderService.getTrucks ( order.getId ( ) );
//        model.addAttribute ( "order", order );
//        model.addAttribute ( "trucks", trucks );
//        return "orders/create/truck";
//    }
//
//    @PostMapping(value = "/savetruck")
//    public String saveTruck(Order order, Model model) {
//        orderService.saveTruckToOrder ( order );
//        System.out.println("order = " + order);
//        List<Truck> trucks = orderService.getTrucks ( order.getId ( ) );
//        model.addAttribute ( "order", order );
//        model.addAttribute ( "trucks", trucks );
//        return "orders/create/truck";
//    }
//
//    @PostMapping(value = "/adddriver")
//    public String addDriver(Order order, Model model) {
//        List<Driver> drivers = orderService.getDrivers(order);
//        model.addAttribute("order", order);
//        model.addAttribute("drivers", drivers);
//        return "orders/create/driver";
//    }
//
//    @PostMapping(value = "/savedriver")
//    public String saveDriver(Order order, Model model) {
//        orderService.saveDriversToOrder ( order );
//        System.out.println("order = " + order);
//        List<Driver> drivers = orderService.getDrivers ( order );
//        model.addAttribute ( "order", order );
//        model.addAttribute ( "drivers", drivers );
//        return "orders/create/driver";
//    }
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

    @GetMapping(value = "/create")
    public String createNewOrder() {
        return "orders/create";
    }
}
