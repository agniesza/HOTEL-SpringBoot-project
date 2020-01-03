package com.agacorporation.demo.component;

import com.agacorporation.demo.domain.RoomReservation;
import com.agacorporation.demo.service.RoomReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
