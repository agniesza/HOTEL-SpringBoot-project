package com.agacorporation.demo.component;

import com.agacorporation.demo.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping
public class ReservationListController {

    @Autowired
    private RoomReservationService roomReservationService;


    @RequestMapping(value="/reservationList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showRoomReservationList(Model model, Pageable pageable){
        model.addAttribute("roomReservationListPage", roomReservationService.getAllRoomReservations(pageable));
        return "reservationList.html";
    }

}
