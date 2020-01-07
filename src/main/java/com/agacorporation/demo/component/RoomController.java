package com.agacorporation.demo.component;

import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value="/reservationList.html", params = "rid", method = RequestMethod.GET)
    public String showRoomDetails(Model model, long rid){
        Room v = roomService.getRoom(rid);

        model.addAttribute("room", v);
        return "roomDetails";
    }
}
