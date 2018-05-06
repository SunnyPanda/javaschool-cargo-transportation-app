package com.katekozlova.cargo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.DriversService;
import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.data.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class JsonController {

    private final OrderService orderService;
    private final DriversService driversService;
    private final CargoService cargoService;
    private String jsonString;

    @Autowired
    public JsonController(OrderService orderService, DriversService driversService, CargoService cargoService) {
        this.orderService = orderService;
        this.driversService = driversService;
        this.cargoService = cargoService;
    }

    @GetMapping(value = "api/info", produces = "application/json")
    @ResponseBody

    public List<Order> generateJson() throws JsonProcessingException {
        List<Order> orders = orderService.getAll();
        return orders;
    }

//    @GetMapping(value = "/api/info", produces = "application/json")
//    public List<Cargo> generateJson() throws JsonProcessingException {
//        List<Cargo> cargo = cargoService.getAllCargo();
//        return cargo;
//    }
}
