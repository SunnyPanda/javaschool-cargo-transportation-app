package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.JsonService;
import com.katekozlova.cargo.data.entity.DriversInfo;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.entity.TrucksInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class JsonController {

    private final JsonService jsonService;

    @Autowired
    public JsonController(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @GetMapping(value = "api/orders", produces = "application/json")
    @ResponseBody
    public List<Order> generateOrdersJson() {
        return jsonService.generateOrdersJson();
    }

    @GetMapping(value = "api/drivers", produces = "application/json")
    @ResponseBody
    public DriversInfo generateDriversJson() {
        return jsonService.generateDriversJson();
    }

    @GetMapping(value = "api/trucks", produces = "application/json")
    @ResponseBody
    public TrucksInfo generateTrucksJson() {
        return jsonService.generateTrucksJson();
    }

    @GetMapping(value = "/api/waypoints/{id}", produces = "application/json")
    @ResponseBody
    public String[] route(@PathVariable("id") long id) {
        return jsonService.route(id);
    }
}
