package com.agacorporation.demo.component.commands;

import org.springframework.util.StringUtils;

import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

public class UserFilter {

    private String phrase;


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


}
