package com.agacorporation.demo.component.commands;

import org.springframework.util.StringUtils;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

public class RoomFilter {

    private String phrase;

    @Positive
    private int numberOfPeople;

    private Date reservationStartDate;
    private Date reservationEndDate;


    @PositiveOrZero
    private Float roomNumber;



    @PositiveOrZero
    private Float maxPrice;


    public boolean isEmpty(){
       // return StringUtils.isEmpty(phrase) && minPrice == null && minPrice == null;
        return numberOfPeople <1 && reservationEndDate == null && reservationStartDate == null;
    }

    public void clear(){
        this.numberOfPeople = 0;
        this.reservationStartDate=null;
        this.reservationEndDate=null;
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
}
