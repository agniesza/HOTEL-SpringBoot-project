package com.agacorporation.demo.service;

import com.agacorporation.demo.component.commands.RoomFilter;
import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.domain.RoomReservation;
import com.agacorporation.demo.domain.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomService {

    List<RoomType> getAllRoomTypes();

    Room getRoom(Long id);

    void deleteRoom(Long id);

    void saveRoom(Room room);

    Page<Room> getAllRooms(RoomFilter search, Pageable pageable);
    Page<Room> getAllRooms2(Pageable pageable);
}
