package com.example.Patika.PatikaWeek4;
import com.example.Patika.PatikaWeek4.entities.MovieEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class Movie {
        private String movieName;
        private MovieGenre movieGenre;
        private Integer releaseYear;
        private String directorName;
        private List<Cast> castList;

        //Method of convert a movie to movie entity
        public MovieEntity convertToMovieEntity(){
                MovieEntity movieEntity = new MovieEntity();
                movieEntity.setName(getMovieName());
                movieEntity.setDirector(getDirectorName());
                movieEntity.setReleaseYear(getReleaseYear());
                movieEntity.setGenre(getMovieGenre());
                return movieEntity;
        }

        //Method of convert a movie entity to movie
        public static Movie convertFromMovieEntity(MovieEntity entity){
                return Movie.builder()
                        .movieName(entity.getName())
                        .movieGenre(entity.getGenre())
                        .releaseYear(entity.getReleaseYear())
                        .directorName(entity.getDirector())
                        .build();
        }
}
