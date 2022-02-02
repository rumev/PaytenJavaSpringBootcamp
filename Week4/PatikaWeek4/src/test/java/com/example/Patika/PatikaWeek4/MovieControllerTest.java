package com.example.Patika.PatikaWeek4;

import com.example.Patika.PatikaWeek4.entities.MovieEntity;
import com.example.Patika.PatikaWeek4.repositories.MovieJpaRepository;
import com.example.Patika.PatikaWeek4.requests.MovieRequest;
import com.example.Patika.PatikaWeek4.responses.MovieCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieControllerTest extends PatikaWeek4ApplicationTests{

    @Autowired
    public MovieJpaRepository movieJpaRepository;

    void should_create_movie(){

        //given
        MovieRequest request =new MovieRequest();
        request.setName("Movie 1");
        request.setDirector("Director 1");
        request.setGenre(MovieGenre.Action);
        request.setReleaseYear(2000);

        //when
        ResponseEntity<MovieCreateResponse> response = testRestTemplate.postForEntity("/movies", request, MovieCreateResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

        //validate movie
        Optional<MovieEntity> movie = movieJpaRepository.findById(response.getBody().getId());
        assertThat(movie).isPresent();
        assertThat(movie.get().getName()).isEqualTo("test movie name");
        assertThat(movie.get().getId()).isEqualTo(1L);


    }
}
