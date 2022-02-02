package com.example.Patika.PatikaWeek4.responses;

import com.example.Patika.PatikaWeek4.Rate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class RateResponse {

    private LocalDateTime createdDate;
    private Long userId;
    private Long movieId;
    private Integer point;

    public static List<RateResponse> convertFromRate(List<Rate> rateList) {
        List<RateResponse> collect = rateList.stream()
                .map(RateResponse::convertFromRate)
                .collect(Collectors.toList());
        return collect;
    }

    private static RateResponse convertFromRate(Rate rate){

        return RateResponse.builder()
                .createdDate(rate.getCreatedTime())
                .userId(rate.getUserId())
                .movieId(rate.getMovieId())
                .point(rate.getPoint())
                .build();
    }

}
