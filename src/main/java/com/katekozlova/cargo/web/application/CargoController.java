package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.data.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/cargo")
public class CargoController {

    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Cargo> cargo = cargoService.getAllCargo();
        return new ModelAndView("cargo/list", "cargo", cargo);
    }
}