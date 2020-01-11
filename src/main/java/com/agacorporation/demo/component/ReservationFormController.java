package com.agacorporation.demo.component;

import com.agacorporation.demo.domain.RoomReservation;
import com.agacorporation.demo.service.RoomReservationService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
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

    @RequestMapping(value="/reservationFormUSR.html", method= RequestMethod.GET)
    public String showFormUSR(Model model, Optional<Long> id){

        model.addAttribute("roomReservation",
                id.isPresent()?
                        roomReservationService.getRoomReservation(id.get()):
                        new RoomReservation());

        return "reservationFormUSR";
    }

    @RequestMapping(value="/reservationFormUSR.html", method= RequestMethod.POST)
    public String processFormUSR(Model model, @Valid @ModelAttribute("roomReservation") RoomReservation v, BindingResult errors){

        if(errors.hasErrors()){
            return "reservationFormUSR";
        }
        model.addAttribute("roomReservation", v);

      //  vehicleService.saveVehicle(v);

      //  return "redirect:vehicleList.html";//po udanym dodaniu/edycji przekierowujemy na listę
        return "reservationFormUSR2";
    }
    @RequestMapping(value="/reservationFormUSR2.html", method= RequestMethod.POST)
    public String processFormUSR2( @Valid @ModelAttribute("roomReservation") RoomReservation v, BindingResult errors){

        if(errors.hasErrors()){
            return "reservationFormUSR2";
        }
        roomReservationService.saveRoomReservation(v);
        //  vehicleService.saveVehicle(v);

          return "redirect:roomReservationList.html";//po udanym dodaniu/edycji przekierowujemy na listę
      //  return "reservationFormUSR2";
    }



    @RequestMapping(value="/reservationFormADM.html", method= RequestMethod.GET)
    public String showFormADM(Model model, Optional<Long> id){

        model.addAttribute("roomReservation",
                id.isPresent()?
                        roomReservationService.getRoomReservation(id.get()):
                        new RoomReservation());

        return "reservationFormUSR";
    }
}
