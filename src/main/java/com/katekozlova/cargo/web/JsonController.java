package com.katekozlova.cargo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.katekozlova.cargo.business.service.*;
import com.katekozlova.cargo.data.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Order> generateOrdersJson() throws JsonProcessingException {
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
}
