package com.example.Patika.PatikaWeek4.controller;


import com.example.Patika.PatikaWeek4.Rate;
import com.example.Patika.PatikaWeek4.requests.RateRequest;
import com.example.Patika.PatikaWeek4.responses.RateResponse;
import com.example.Patika.PatikaWeek4.services.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RateController {

    private RateService rateService;

    //Method of create rate
    @PostMapping("/rates")
    public void rate(@RequestBody @Valid RateRequest rateRequest) {
        Rate rate = rateRequest.convertToRate();
        rateService.rateToMovie(rate);
    }
    //Method of list rates
    @GetMapping("/rates")
    public List<RateResponse> retrieveByMovieId(@RequestParam Long movieId) {
        List<Rate> rateList = rateService.retrieveByMovieId(movieId);
        return RateResponse.convertFromRate(rateList);
    }
}
