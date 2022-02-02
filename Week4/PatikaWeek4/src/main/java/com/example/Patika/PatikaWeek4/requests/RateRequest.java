package com.example.Patika.PatikaWeek4.requests;

import com.example.Patika.PatikaWeek4.Rate;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RateRequest {


    @NotNull
    private Long userId;

    @NotNull
    private Long movieId;

    @Min(1)
    @Max(5)
    @NotNull
    private Integer point;

    public Rate convertToRate(){
        return Rate.builder()
                .userId(userId)
                .movieId(movieId)
                .point(point)
                .build();
    }
}
