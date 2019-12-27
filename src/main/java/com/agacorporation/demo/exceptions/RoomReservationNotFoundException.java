package com.agacorporation.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such reservation")
public class RoomReservationNotFoundException extends RuntimeException{

    public RoomReservationNotFoundException(){
        super(String.format("Rezerwacja nie istnieje"));
    }

    public RoomReservationNotFoundException(Long id){
        super(String.format("Rezerwacja o id %d nie istnieje", id));
    }
}
