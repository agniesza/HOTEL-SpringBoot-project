package com.agacorporation.demo.service;

import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.domain.RoomReservation;
import com.agacorporation.demo.domain.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomReservationService {

    List<Room> getAllRooms();

    List<RoomType> getAllRoomTypes();

    Page<RoomReservation> getAllRoomReservations(Pageable pageable);

    RoomReservation getRoomReservations(Long id);

    void deleteRoomReservation(Long id);

    void saveRoomReservation(RoomReservation roomReservation);
}
