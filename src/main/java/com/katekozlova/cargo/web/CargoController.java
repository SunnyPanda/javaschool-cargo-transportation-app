package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.validation.CargoValidator;
import com.katekozlova.cargo.data.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/manager/cargo")
public class CargoController {

    private final CargoService cargoService;

    private final CargoValidator cargoValidator;

    @Autowired
    public CargoController(CargoService cargoService, CargoValidator cargoValidator) {
        this.cargoService = cargoService;
        this.cargoValidator = cargoValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(cargoValidator);
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Cargo> cargo = cargoService.getAllCargo();
        return new ModelAndView("cargo/list", "cargo", cargo);
    }

    @PostMapping("/search")
    public String searchCargo(@RequestParam("number") long number, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "orders/list";
//        }
        return "redirect:/manager/cargo/search/" + number;
    }

    @GetMapping(value = "/search/{number}")
    public String searchCargoView(@PathVariable("number") long number, Model model) {
        Cargo cargo = cargoService.getCargoByNumber(number);
        model.addAttribute("cargo", cargo);
        return "cargo/search";
    }

    @GetMapping(value = "/status")
    public ModelAndView status() {
        List<Cargo> cargo = cargoService.getAllCargo();
        return new ModelAndView("cargo/status", "cargo", cargo);
    }
}
