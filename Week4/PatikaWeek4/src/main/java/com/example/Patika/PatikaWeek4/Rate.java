package com.example.Patika.PatikaWeek4;

import com.example.Patika.PatikaWeek4.entities.MovieEntity;
import com.example.Patika.PatikaWeek4.entities.RateEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@EqualsAndHashCode
public class Rate {

    private LocalDateTime createdTime;
    private Long userId;
    private Long movieId;
    private Integer point;

    //Method of convert a rate to rate entity
    public RateEntity convertToRateEntity(MovieEntity movieEntity){

        RateEntity entity = new RateEntity();
        entity.setCreatedDate(LocalDateTime.now());
        entity.setUserId(getUserId());
        entity.setMovie(movieEntity);
        entity.setPoint(point);
        return entity;
    }
    //Method of convert a rate entity to rate
    public static Rate convertFromRateEntity(RateEntity entity){
        return Rate.builder()
                .createdTime(entity.getCreatedDate())
                .userId(entity.getUserId())
                .movieId(entity.getMovie().getId())
                .point(entity.getPoint())
                .build();
    }
}
