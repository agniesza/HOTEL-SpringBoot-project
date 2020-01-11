package com.agacorporation.demo.repository;

import com.agacorporation.demo.domain.RoomReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomReservationRepository
       extends JpaRepository<RoomReservation, Long>, JpaSpecificationExecutor<RoomReservation>
{
    //nazwa metody jest jednocześnie zapytaniem
    //Page<RoomReservation> findByNameContaining(String phrase, Pageable pageable);

    //nad klasą Vehicle znajduje się definicja zapytania (@NamedQuery) powiązana z tą metodą
  //  Page<RoomReservation> findAllRoomReservationsUsingNamedQuery(String phrase, Pageable pageable);

    @Query("SELECT v FROM RoomReservation v WHERE " +
            "(" +
            ":phrase is null OR :phrase = '' OR "+
            "upper(v.user.firstName) LIKE upper(:phrase) OR " +
            "upper(v.user.lastName) LIKE upper(:phrase) OR " +
            "upper(v.user.login) LIKE upper(:phrase)" +
            ") "
            //+
          //  "AND " +
           // "(:min is null OR :min <= v.price) " +
            //"AND (:max is null OR :max >= v.price)"
    )
    Page<RoomReservation> findAllRoomReservationsUsingFilter(@Param("phrase") String p, Pageable pageable);



}
