package com.agacorporation.demo.repository;

import com.agacorporation.demo.domain.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReservationRepository
       extends JpaRepository<RoomReservation, Long>
{

}
