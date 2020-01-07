package com.agacorporation.demo.component;

import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping({"/roomDetails"})
    public String showRoomDetails(Model model) {
        return "roomDetails.html";
    }

    @RequestMapping(value="/reservationList.html", params = {"rid"}, method = RequestMethod.GET)
    public String showRoomDetails(Model model, long rid){
        Room r = roomService.getRoom(rid);
        model.addAttribute("room", r);
        return "roomDetails";
    }


}
