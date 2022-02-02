package com.example.Patika.PatikaWeek4.repositories;

import com.example.Patika.PatikaWeek4.entities.RateEntity;

import java.util.List;

public interface RateDao {

    void rateToMovie(RateEntity entity);

    List<RateEntity> retrieveByMovieId(Long movieId);
}
