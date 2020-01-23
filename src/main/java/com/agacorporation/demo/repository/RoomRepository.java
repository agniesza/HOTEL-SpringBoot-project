package com.agacorporation.demo.repository;

import com.agacorporation.demo.domain.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface RoomRepository extends JpaRepository<Room, Long> {

/*
SELECT pub.id, pub.revenue
    FROM Publisher pub JOIN pub.magazines mag WHERE mag.price > 5.00
 */
    @Query("SELECT distinct v FROM Room v JOIN v.roomReservations rez WHERE " +
            "(" +
            "v.maxNumberOfPeople >= (:number) AND "+
            "( :startd NOT BETWEEN rez.reservationStartDate AND rez.reservationEndDate ) AND "+
            "( :endd NOT BETWEEN rez.reservationStartDate AND rez.reservationEndDate )"+

    ")"


    )
    Page<Room> findAllRoomsUsingFilter(@Param("number") int p, @Param("startd") Date s, @Param("endd") Date e, Pageable pageable);

    @Query("SELECT distinct v FROM Room v "

  )
    Page<Room> findAllRooms(Pageable pageable);

}
