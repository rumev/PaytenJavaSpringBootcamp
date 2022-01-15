package com.example.Patika.PatikaWeek2;

import org.springframework.stereotype.Service;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Service("ms")
public class MovieService {

    private List<Movie> dummyMovieList =loadDummyMovies();

    // Method for create dummy movie data
    private static List<Movie> loadDummyMovies(){
            List<Movie> createMovieList = new ArrayList<Movie>();
            createMovieList.add(Movie.builder()
                    .movieName("Fight Club")
                    .movieGenre(MovieGenre.Drama)
                    .releaseYear(1999)
                    .directorName("David Fincher")
                    .point(9.0)
                    .castList(List.of(
                            Cast.builder()
                                    .castName("Brad Pitt")
                                    .castAge(59)
                                    .build(),
                            Cast.builder()
                                    .castName("Edward Norton")
                                    .castAge(53)
                                    .build(),
                            Cast.builder()
                                    .castName("Meat Loaf")
                                    .castAge(75)
                                    .build()))
                    .build());
            createMovieList.add(Movie.builder()
                    .movieName("Gladiator")
                    .movieGenre(MovieGenre.Action)
                    .releaseYear(2000)
                    .directorName("Ridley Scott")
                    .point(9.5)
                    .castList(List.of(
                            Cast.builder()
                                    .castName("Russell Crowe")
                                    .castAge(58)
                                    .build(),
                            Cast.builder()
                                    .castName("Joaquin Phoenix")
                                    .castAge(48)
                                    .build(),
                            Cast.builder()
                                    .castName("Connie Nielson")
                                    .castAge(57)
                                    .build()))
                    .build());
        return createMovieList;
    }

    // Method for add movies with PostMapping
    public String addMovies(Movie movie){
        dummyMovieList.add(Movie.builder()
                        .movieName(movie.getMovieName())
                        .movieGenre(movie.getMovieGenre())
                        .releaseYear(movie.getReleaseYear())
                        .directorName(movie.getDirectorName())
                        .point(movie.getPoint())
                        .castList(movie.getCastList())
                        .build());
        return "Movie added.";
    }

    //Method for delete movies with PostMapping
    public String deleteMovie(String movieName){
         dummyMovieList.removeIf(movie -> movie.getMovieName().equals(movieName));
        return "Movie deleted.";
    }

    //Method for give point to movie by user
    public void rateMovie(String movieName,Double point){
        for(Movie movie : dummyMovieList){
            if (movie.getMovieName().equals(movieName)){
                movie.setPoint(point);
            }
        }
    }
}
