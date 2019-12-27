package com.agacorporation.demo.component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class ReservationListController {

    @RequestMapping(value="/reservationList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showVehicleList(Model model) {
        return "reservationList.html";
    }

}
