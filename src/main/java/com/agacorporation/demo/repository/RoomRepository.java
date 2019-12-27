package com.agacorporation.demo.repository;

import com.agacorporation.demo.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
