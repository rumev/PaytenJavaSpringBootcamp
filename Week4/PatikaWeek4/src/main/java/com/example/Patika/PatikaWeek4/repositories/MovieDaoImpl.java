package com.example.Patika.PatikaWeek4.repositories;
import com.example.Patika.PatikaWeek4.entities.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao {

    private final MovieJpaRepository movieJpaRepository;


    @Override
    public MovieEntity save(MovieEntity entity) {
        return movieJpaRepository.save(entity);
    }

    @Override
    public MovieEntity retrieve(Long id) {
        Optional<MovieEntity> movieEntityOptional = movieJpaRepository.findById(id);

        if (movieEntityOptional.isPresent())
            return movieEntityOptional.get();
        else
            throw new RuntimeException();
    }
}