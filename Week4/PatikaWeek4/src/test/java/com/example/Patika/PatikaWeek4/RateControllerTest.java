package com.example.Patika.PatikaWeek4;


import com.example.Patika.PatikaWeek4.entities.RateEntity;
import com.example.Patika.PatikaWeek4.repositories.RateJpaRepository;
import com.example.Patika.PatikaWeek4.requests.RateRequest;
import com.example.Patika.PatikaWeek4.responses.RateCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RateControllerTest extends PatikaWeek4ApplicationTests{

    @Autowired
    public RateJpaRepository rateJpaRepository;

    void should_create_rate(){

        //given
        RateRequest request =new RateRequest();
        request.setUserId(1L);
        request.setMovieId(1L);
        request.setPoint(4);

        //when
        ResponseEntity<RateCreateResponse> response = testRestTemplate.postForEntity("/rates", request, RateCreateResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

        //validate rate
        Optional<RateEntity> rate = rateJpaRepository.findById(response.getBody().getId());
        assertThat(rate).isPresent();
        assertThat(rate.get().getId()).isEqualTo(1L);
        assertThat(rate.get().getUserId()).isEqualTo(1L);
    }
}
