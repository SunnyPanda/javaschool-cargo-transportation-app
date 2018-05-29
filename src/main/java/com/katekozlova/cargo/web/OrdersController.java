package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.OrderService;
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
@RequestMapping(value = "/manager/orders")
public class OrdersController {

    private final OrderService orderService;


    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Order> orders = orderService.getAllOrders();
//        orderService.setExistingOrdersTravelTime();
        return new ModelAndView("orders/list", "orders", orders);
    }

    @PostMapping(value = "/search")
    public String searchOrder(@RequestParam("uniqueNumber") long uniqueNumber) {
        return "redirect:/manager/orders/search/" + uniqueNumber;
    }

    @GetMapping(value = "/search/{unique-number}")
    public String searchOrderView(@PathVariable("unique-number") long id, Model model) {
        Order order = orderService.findByUniqueNumber(id);
        model.addAttribute("order", order);
        return "orders/search";
    }


    @GetMapping(value = "/waypoints/{id}")
    public String getWaypoints(@PathVariable("id") long id, Model model) {
        Order order = orderService.findById(id);
        List<Waypoint> waypoints = orderService.getOrderWaypoints(id);
        model.addAttribute("order", order);
        model.addAttribute("waypoints", waypoints);
        return "orders/waypoints";
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
