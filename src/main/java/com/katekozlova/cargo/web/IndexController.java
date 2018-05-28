package com.katekozlova.cargo.web;

import com.katekozlova.cargo.business.service.CargoService;
import com.katekozlova.cargo.business.service.OrderService;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.security.AppUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    private final OrderService orderService;
    private final CargoService cargoService;

    @Autowired
    public IndexController(OrderService orderService, CargoService cargoService) {
        this.orderService = orderService;
        this.cargoService = cargoService;
    }

    @GetMapping
    public String index(HttpServletRequest request) {
        final AppUserPrincipal principal = (AppUserPrincipal) ((UsernamePasswordAuthenticationToken) request.getUserPrincipal()).getPrincipal();
        if (request.isUserInRole("DRIVER")) {
            final Driver driver = principal.getDriver();
            return "redirect:drivers/info/" + driver.getId();
        } else {
            return "redirect:orders/list";
        }
    }


    @GetMapping(value = "/test")
    public String test() {
        return "/test";
    }
}
