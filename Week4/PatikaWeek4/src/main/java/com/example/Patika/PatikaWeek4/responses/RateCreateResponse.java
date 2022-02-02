package com.example.Patika.PatikaWeek4.responses;


import com.example.Patika.PatikaWeek4.Rate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RateCreateResponse {

    private Long id;

    public static RateCreateResponse convertToRateResponse(Long id){
        return RateCreateResponse.builder()
                .id(id)
                .build();
    }
}
