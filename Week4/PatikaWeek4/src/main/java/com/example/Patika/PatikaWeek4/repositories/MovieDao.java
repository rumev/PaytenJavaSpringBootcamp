package com.example.Patika.PatikaWeek4.repositories;

import com.example.Patika.PatikaWeek4.entities.MovieEntity;

public interface MovieDao {

    MovieEntity save(MovieEntity entity);

    MovieEntity retrieve(Long id);


}
