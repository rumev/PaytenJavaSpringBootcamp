package com.example.Patika.PatikaWeek4.repositories;


import com.example.Patika.PatikaWeek4.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {
}
