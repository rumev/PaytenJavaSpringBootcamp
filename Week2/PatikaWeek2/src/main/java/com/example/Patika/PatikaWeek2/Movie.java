package com.example.Patika.PatikaWeek2;
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
        private Double point;


}
