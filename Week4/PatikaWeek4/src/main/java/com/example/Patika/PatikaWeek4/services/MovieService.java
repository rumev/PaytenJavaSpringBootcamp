package com.example.Patika.PatikaWeek4.services;

import com.example.Patika.PatikaWeek4.Movie;


public interface MovieService {

    Long create(Movie movie);

    Movie retrieve(Long id);
}
