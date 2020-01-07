package com.agacorporation.demo.component;

import com.agacorporation.demo.service.RoomReservationService;
import com.agacorporation.demo.service.RoomService;
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

import javax.servlet.http.HttpServletRequest;
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
    @GetMapping({"/deleteInfo"})
    public String showDeleteInfo(Model model) {
        return "deleteInfo.html";
    }

    @RequestMapping(value="/reservationList.html", params = "id", method = RequestMethod.GET)
    public String deleteRoomReservation(long id, HttpServletRequest request){
        roomReservationService.deleteRoomReservation(id);
        String queryString = prepareQueryString(request.getQueryString());
    //    return String.format("redirect:reservationList.html?%s", queryString);//robimy przekierowanie, ale zachowując parametry pageingu
  //  return "reservationList.html";
        return "deleteInfo";
    }
    private String prepareQueryString(String queryString) {//np., did=20&page=2&size=20
        return queryString.substring(queryString.indexOf("&")+1);//obcinamy parametr did, bo inaczej znowu będzie wywołana metoda deleteVihicle
    }






}
