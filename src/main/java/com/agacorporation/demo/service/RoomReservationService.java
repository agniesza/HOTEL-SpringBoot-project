package com.agacorporation.demo.service;

import com.agacorporation.demo.component.commands.RoomReservationFilter;
import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.domain.RoomReservation;
import com.agacorporation.demo.domain.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface RoomReservationService {

    List<Room> getAllRooms();

    List<RoomType> getAllRoomTypes();

    Page<RoomReservation> getAllRoomReservations(RoomReservationFilter search, Pageable pageable);

    Page<RoomReservation> getUserRoomReservations(RoomReservationFilter search, Pageable pageable);

    RoomReservation getRoomReservation(Long id);

    void deleteRoomReservation(Long id);

    void saveRoomReservation(RoomReservation roomReservation);
}
