package com.example.Patika.PatikaWeek4;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import java.util.List;

@Getter
@Setter
@Builder
public class User {
    private Long userId;
    private String userName;
    private List<WatchList> userWatchLists;

}
