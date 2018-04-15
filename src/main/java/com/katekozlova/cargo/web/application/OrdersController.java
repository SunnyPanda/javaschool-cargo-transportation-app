package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.entity.Waypoint;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Order> orders = orderService.getAllOrders();
        return new ModelAndView("orders/list", "orders", orders);
    }

    @GetMapping(value = "/waypoints/{id}")
    public ModelAndView getWaypoints(@PathVariable("id") long id) {
        List<Waypoint> waypoints = orderService.getOrdersWaypoints(id);
        return new ModelAndView("orders/waypoints", "waypoints", waypoints);
    }

//    @GetMapping(value = "/waypoints")
//    public ModelAndView getWaypoints() {
//        List<Waypoint> waypoints = orderService.getOrdersWaypoints();
//        return new ModelAndView("orders/waypoints", "waypoints", waypoints);
//    }
}
