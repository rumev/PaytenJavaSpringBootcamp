package com.example.Patika.PatikaWeek4.controller;

import com.example.Patika.PatikaWeek4.Movie;
import com.example.Patika.PatikaWeek4.requests.MovieRequest;
import com.example.Patika.PatikaWeek4.responses.MovieCreateResponse;
import com.example.Patika.PatikaWeek4.responses.MovieResponse;
import com.example.Patika.PatikaWeek4.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    //Method of create movie from rest request
    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieCreateResponse create(@RequestBody @Valid MovieRequest request){
        Movie movie = request.convertToMovie();
        Long id =movieService.create(movie);
        return MovieCreateResponse.convertToMovieResponse(id);
    }

    //Method of list movie by id
    @GetMapping("/movies/{id}")
    public MovieResponse retrieve(@PathVariable Long id){
        Movie movie =movieService.retrieve(id);
        return MovieResponse.convertFrom(movie);
    }

}
