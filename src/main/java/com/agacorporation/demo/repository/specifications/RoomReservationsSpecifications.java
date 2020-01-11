package com.agacorporation.demo.repository.specifications;

import com.agacorporation.demo.domain.RoomReservation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class RoomReservationsSpecifications {
    public static Specification<RoomReservation> findByPhrase(final String phrase)
    {
        return (root, query, cb) -> {
            if(StringUtils.isEmpty(phrase) == false){
                String phraseLike = "%"+phrase.toUpperCase() +"%";
                return cb.or(
                        cb.or(
                                cb.like(cb.upper(root.get("user").get("firstName")), phraseLike),
                                cb.like(cb.upper(root.get("user").get("lastName")), phraseLike)
                        ),
                        cb.like(cb.upper(root.get("user").get("login")), phraseLike)
                );
            }
            return null;
        };
    }
   /* public static Specification<RoomReservation> findByPriceRange(Float minPrice,
                                                          Float maxPrice) {
        return (root, query, cb) -> {
            if(minPrice != null && maxPrice != null){
                return cb.between(root.get("price"), minPrice, maxPrice);
            }else if(minPrice != null){ //tylko min

                return cb.greaterThan(root.get("price"), minPrice);

            }else if(maxPrice != null) { //tylko max

                return cb.lessThan(root.get("price"), maxPrice);

            }
            return null;
        };
    }

    */
}