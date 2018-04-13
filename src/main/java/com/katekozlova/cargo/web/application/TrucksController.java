package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.domain.ListOfTrucks;
import com.katekozlova.cargo.business.service.TrucksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/trucks")
public class TrucksController {

    @Autowired
    private TrucksService trucksService;

    @RequestMapping(method = RequestMethod.GET)
    public String getDrivers(Model model) {

        List<ListOfTrucks> listOfTrucksList = this.trucksService.getAllDrivers();
        model.addAttribute("listOfTrucks", listOfTrucksList);

        return "trucks";
    }
}
