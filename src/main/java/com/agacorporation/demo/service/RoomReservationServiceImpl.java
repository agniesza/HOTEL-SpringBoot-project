package com.agacorporation.demo.service;

import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.domain.RoomReservation;
import com.agacorporation.demo.domain.RoomType;
import com.agacorporation.demo.repository.RoomRepository;
import com.agacorporation.demo.repository.RoomReservationRepository;
import com.agacorporation.demo.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RoomReservationServiceImpl implements RoomReservationService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomReservationRepository roomReservationRepository;


    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public List<RoomType> getAllRoomTypes() {
        return null;
    }

    @Override
    public Page<RoomReservation> getAllRoomReservations(Pageable pageable) {
        return null;
    }

    @Override
    public RoomReservation getRoomReservations(Long id) {
        return null;
    }

    @Override
    public void deleteRoomReservation(Long id) {

    }

    @Override
    public void saveRoomReservation(RoomReservation roomReservation) {

    }
}
