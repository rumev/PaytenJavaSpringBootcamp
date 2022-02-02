package com.example.Patika.PatikaWeek4;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class WatchList {
    private String watchListName;
    private List<Movie> watchList;
}
