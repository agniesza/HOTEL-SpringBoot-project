package com.agacorporation.demo.component;

import com.agacorporation.demo.domain.RoomReservation;
import com.agacorporation.demo.service.RoomReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping
public class ReservationFormController {

    private RoomReservationService roomReservationService;

    //Wstrzyknięcie zależności przez konstruktor. Od wersji 4.3 Springa nie trzeba używać adnontacji @Autowired, gdy mamy jeden konstruktor
    //@Autowired
    public ReservationFormController(RoomReservationService roomReservationService)
    {
        this.roomReservationService = roomReservationService;
    }

    @RequestMapping(value="/reservationForm.html", method= RequestMethod.GET)
    public String showForm(Model model, Optional<Long> id){

        model.addAttribute("roomReservation",
                id.isPresent()?
                        roomReservationService.getRoomReservations(id.get()):
                        new RoomReservation());

        return "reservationForm";
    }

}
