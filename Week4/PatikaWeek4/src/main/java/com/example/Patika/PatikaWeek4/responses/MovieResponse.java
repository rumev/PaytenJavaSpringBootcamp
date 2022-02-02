package com.example.Patika.PatikaWeek4.responses;

import com.example.Patika.PatikaWeek4.Movie;
import com.example.Patika.PatikaWeek4.MovieGenre;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MovieResponse {


    private String name;
    private MovieGenre genre;
    private Integer releaseYear;
    private String director;
    private List<CastResponse> castResponseList;

    public static MovieResponse convertFrom(Movie movie){

        return MovieResponse.builder()
                .name(movie.getMovieName())
                .genre(movie.getMovieGenre())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirectorName())
                .build();
    }
}
