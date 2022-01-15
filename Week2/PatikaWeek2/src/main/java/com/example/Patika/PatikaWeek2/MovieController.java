package com.example.Patika.PatikaWeek2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService ms;

    //Method to list movies with Rest
    @GetMapping( "/movies")
    public List<Movie> moviesList(){
        return ms.getDummyMovieList();
    }

    //Method to add movies with Rest
    @PostMapping("/addMovie")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addMovie(@RequestBody Movie movie){
        return ms.addMovies(movie);
    }

    //Method to delete movies with Rest
    @DeleteMapping("/movies/{movieName}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String deleteMovie(@PathVariable("movieName") String movieName){

        return ms.deleteMovie(movieName);
    }

    //Method to rate movie with Rest
    @PutMapping("/movies/{movieName}/point")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void  pointMovie(@PathVariable("movieName") String movieName,@RequestBody Double point){

    }
}
