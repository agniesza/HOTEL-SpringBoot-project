package com.agacorporation.demo.component.commands;

import org.springframework.util.StringUtils;

import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

public class RoomReservationFilter {

    private String phrase;

    @PositiveOrZero
    private int numberOfPeople;

    private Date reservationStartDate;
    private Date reservationEndDate;


    @PositiveOrZero
    private Float roomNumber;



    @PositiveOrZero
    private Float maxPrice;


    public boolean isEmpty(){
       // return StringUtils.isEmpty(phrase) && minPrice == null && minPrice == null;
        return StringUtils.isEmpty(phrase) && reservationEndDate == null && reservationStartDate == null;
    }

    public void clear(){
        this.phrase = "";
        this.reservationStartDate=null;
        this.reservationEndDate=null;
    }

    public String getPhraseLIKE(){

        if(StringUtils.isEmpty(phrase)) {
            return null;
        }else{
            return "%"+phrase+"%";
        }

    }



    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
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
