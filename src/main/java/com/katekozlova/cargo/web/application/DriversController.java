package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.business.domain.ListOfDrivers;
import com.katekozlova.cargo.business.service.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Contended;

import java.util.List;

@Controller
@RequestMapping(value = "/drivers")
public class DriversController {

    @Autowired
    private DriversService driversService;

    @RequestMapping(method = RequestMethod.GET)
    public String getDrivers(Model model) {

        List<ListOfDrivers> listOfDriversList = this.driversService.getAllDrivers();
        model.addAttribute("listOfDrivers", listOfDriversList);

        return "drivers";
    }
}


//@Controller
//@RequestMapping(value="/reservations")
//public class ReservationController {
//    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
//
//    @Autowired
//    private ReservationService reservationService;
//
//    @RequestMapping(method= RequestMethod.GET)
//    public String getReservations(@RequestParam(value = "date", required = false)String dateString, Model model){
//        Date date = null;
//        if (null != dateString) {
//            try {
//                date = DATE_FORMAT.parse(dateString);
//            } catch (ParseException pe) {
//                date = new Date();
//            }
//        } else {
//            date = new Date();
//        }
//        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsForDate(date);
//        model.addAttribute("roomReservations", roomReservationList);
//
//
//        return "reservations";
//    }
//}