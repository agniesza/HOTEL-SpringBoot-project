package com.agacorporation.demo.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Past;
import java.util.Date;

public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu roomtype wraz z obiektem room.
    @JoinColumn(name="room_id", nullable = false)
    private Room room;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu roomtype wraz z obiektem room.
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name = "end_price", nullable = false)
    private int endPrice;

    @Column(name="check-in_date")
    private Date checkInDate;

    @Column(name="check-out_date")
    private Date checkOutDate;

    @Column(name="number_of_people", nullable=false)
    private int numberOfPeople;

    @Column(name="reservation_start_date", nullable=false)
    private Date reservationStartDate;

    @Column(name="reservation_end_date", nullable=false)
    private Date reservationEndDate;

    @Column
    private boolean verified;

    @Column
    private boolean paid;


}
