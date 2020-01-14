package com.agacorporation.demo.domain;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Entity
@Table(name = "room_reservations")
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//
    @JoinColumn(name="rooms_id", nullable = false)
    private Room room;


    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//
    @JoinColumn(name="users_id", nullable = false)
    private User user;

    @Column(name = "end_price", nullable = false)
    private int endPrice;

    @Column(name="check_in_date")
    private Date checkInDate;

    @Column(name="check_out_date")
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

    public RoomReservation(@Valid Room room, @Valid User user, int endPrice, Date checkInDate, Date checkOutDate, int numberOfPeople, Date reservationStartDate, Date reservationEndDate, boolean verified, boolean paid) {
        this.room = room;
        this.user = user;
        this.endPrice = endPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfPeople = numberOfPeople;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.verified = verified;
        this.paid = paid;
    }
    public RoomReservation(@Valid Room room, @Valid User user, int endPrice, Date checkInDate, Date checkOutDate, int numberOfPeople, Date reservationStartDate, Date reservationEndDate) {
        this.room = room;
        this.user = user;
        this.endPrice = endPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfPeople = numberOfPeople;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }
    public RoomReservation(){
this.user=new User();
this.room=new Room();
    }
    public Room getRoom() {
        return room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(int endPrice) {
        this.endPrice = endPrice;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Date getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(Date reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public Date getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(Date reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
