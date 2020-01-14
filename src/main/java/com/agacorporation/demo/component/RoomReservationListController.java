package com.agacorporation.demo.component;

import com.agacorporation.demo.component.commands.RoomReservationFilter;
import com.agacorporation.demo.service.RoomReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@SessionAttributes("searchCommand")
public class RoomReservationListController {

    @Autowired
    private RoomReservationService roomReservationService;

    @GetMapping({"/deleteInfo"})
    public String showDeleteInfo(Model model) {
        return "deleteInfo.html";
    }

    @ModelAttribute("searchCommand")
    public RoomReservationFilter getSimpleSearch(){
        return new RoomReservationFilter();
    }

    @GetMapping(value="/reservationList.html", params = {"all"})
    public String resetreservationList(@ModelAttribute("searchCommand") RoomReservationFilter search){
        search.clear();
        return "redirect:reservationList.html";
    }
    @RequestMapping(value="/reservationList.html", method = {RequestMethod.GET})
    public String showReservationList(Model model, Pageable pageable, @Valid @ModelAttribute("searchCommand") RoomReservationFilter search, BindingResult result, Principal principal){

        model.addAttribute("roomReservationListPage", roomReservationService.getAllRoomReservations(search, pageable));
        System.out.println("fraza "+search.getPhrase());
        System.out.println("name: "+principal.getName());

        return "reservationList";
        // return "redirect:reservationList";
    }
    @RequestMapping(value="/reservationList.html", method = {RequestMethod.POST})
    public String showReservationList2(Model model, Pageable pageable, @Valid @ModelAttribute("searchCommand") RoomReservationFilter search, BindingResult result){

        model.addAttribute("roomReservationListPage", roomReservationService.getAllRoomReservations(search, pageable));
        System.out.println("fraza "+search.getPhrase());
        return "reservationList";
        // return "redirect:reservationList";
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
