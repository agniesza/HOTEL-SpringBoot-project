package com.agacorporation.demo.service;

import com.agacorporation.demo.component.commands.RoomReservationFilter;
import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.domain.RoomReservation;
import com.agacorporation.demo.domain.RoomType;
import com.agacorporation.demo.exceptions.RoomReservationNotFoundException;
import com.agacorporation.demo.repository.RoomRepository;
import com.agacorporation.demo.repository.RoomReservationRepository;
import com.agacorporation.demo.repository.RoomTypeRepository;
import com.agacorporation.demo.repository.specifications.RoomReservationsSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class RoomReservationServiceImpl implements RoomReservationService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomReservationRepository roomReservationRepository;


    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public Page<RoomReservation> getAllRoomReservations(RoomReservationFilter search, Pageable pageable)  {

        Page page;
        if(search.isEmpty()){
            page = roomReservationRepository.findAll(pageable);
        }else{

            page = roomReservationRepository.findAllRoomReservationsUsingFilter(search.getPhraseLIKE(), pageable);
        }

        return page;
    }
    @Override
    public Page<RoomReservation> getUserRoomReservations(RoomReservationFilter search, Pageable pageable)  {

        Page page;
        if(search.isEmpty()){
            page = roomReservationRepository.findAll(pageable);
        }else{

            page = roomReservationRepository.findUserRoomReservations(search.getPhraseLIKE(), pageable);
        }

        return page;
    }
    @Transactional
    @Override
    public RoomReservation getRoomReservation(Long id) {
       Optional<RoomReservation> optionalRoomReservation = roomReservationRepository.findById(id);
        RoomReservation roomReservation = optionalRoomReservation.orElseThrow(()->new RoomReservationNotFoundException(id));
        return roomReservation;



    }

    @Override
    public void deleteRoomReservation(Long id) {
        if(roomReservationRepository.existsById(id) == true){
          roomReservationRepository.deleteById(id);
        }else{
            throw new RoomReservationNotFoundException(id);
        }



    }

    @Override
    public void saveRoomReservation(RoomReservation roomReservation) {
            roomReservationRepository.save(roomReservation);
    }



}
