package com.example.Patika.PatikaWeek2;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class WatchList {
    private String watchListName;
    private List<Movie> watchList;
}
