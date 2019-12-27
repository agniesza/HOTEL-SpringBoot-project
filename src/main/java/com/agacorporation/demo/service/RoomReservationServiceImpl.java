package com.agacorporation.demo.service;

import com.agacorporation.demo.repository.RoomRepository;
import com.agacorporation.demo.repository.RoomReservationRepository;
import com.agacorporation.demo.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomReservationServiceImpl {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomReservationRepository roomReservationRepository;



}
