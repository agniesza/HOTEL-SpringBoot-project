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
    private Date checkInDate;
    private Date checkOutDate;

    @PositiveOrZero
    private Float roomNumber;



    @PositiveOrZero
    private Float maxPrice;


    public boolean isEmpty(){
       // return StringUtils.isEmpty(phrase) && minPrice == null && minPrice == null;
        return StringUtils.isEmpty(phrase);
    }

    public void clear(){
        this.phrase = "";
      //  this.minPrice = null;
       // this.maxPrice = null;
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

    public Float getMinPrice() {
        return null;
    }

    public void setMinPrice(Float minPrice) {
     //   this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
     //   return maxPrice;
        return null;
    }

    public void setMaxPrice(Float maxPrice) {
       // this.maxPrice = maxPrice;
    }
}
