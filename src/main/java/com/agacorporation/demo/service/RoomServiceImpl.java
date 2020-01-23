package com.agacorporation.demo.service;

import com.agacorporation.demo.component.commands.RoomFilter;
import com.agacorporation.demo.domain.Room;
import com.agacorporation.demo.domain.RoomType;
import com.agacorporation.demo.exceptions.RoomNotFoundException;
import com.agacorporation.demo.exceptions.RoomReservationNotFoundException;
import com.agacorporation.demo.repository.RoomRepository;
import com.agacorporation.demo.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomType> getAllRoomTypes() {
        return null;
    }

    @Override
    public Page<Room> getAllRooms(RoomFilter search, Pageable pageable)  {

        Page page;

            page = roomRepository.findAllRoomsUsingFilter(search.getNumberOfPeople(),search.getReservationStartDate(), search.getReservationEndDate(), pageable);


        return page;
    }

    @Override
    public Page<Room> getAllRooms2(Pageable pageable) {
        Page page;

        page = roomRepository.findAllRooms(pageable);
return page;
    }


    @Override
    public Room getRoom(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        Room room = optionalRoom.orElseThrow(()->new RoomNotFoundException(id));
        return room;
    }

    @Override
    public void deleteRoom(Long id) {
        if(roomRepository.existsById(id) == true){
            roomRepository.deleteById(id);
        }else{
            throw new RoomNotFoundException(id);
        }
    }

    @Override
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }
}
