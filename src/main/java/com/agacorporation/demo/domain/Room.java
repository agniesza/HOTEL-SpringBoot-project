package com.agacorporation.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Set;


@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "max_number_of_people", nullable = false)
    private int maxNumberOfPeople;

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private int price;

    @Column(name = "double_beds", nullable = false)
    private int doubleBeds;

    @Column(name = "single_beds", nullable = false)
    private int singleBeds;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu roomtype wraz z obiektem room.
    @JoinColumn(name="types_id", nullable = false)
    private RoomType roomType;


    @OneToMany(mappedBy="room")
    private Set<RoomReservation> roomReservations;

    public Room(int maxNumberOfPeople, int roomNumber, int floor, int price, int doubleBeds, int singleBeds, @Valid RoomType roomType) {
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.price = price;
        this.doubleBeds = doubleBeds;
        this.singleBeds = singleBeds;
        this.roomType = roomType;
    }
    public Room(){
        this.roomType=new RoomType();
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDoubleBeds() {
        return doubleBeds;
    }

    public void setDoubleBeds(int doubleBeds) {
        this.doubleBeds = doubleBeds;
    }

    public int getSingleBeds() {
        return singleBeds;
    }

    public void setSingleBeds(int singleBeds) {
        this.singleBeds = singleBeds;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Set<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(Set<RoomReservation> roomReservations) {
        this.roomReservations = roomReservations;
    }
}
