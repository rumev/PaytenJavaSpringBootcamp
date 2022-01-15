package com.example.Patika.PatikaWeek2;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter
@Builder
public class User {
    private Long userId;
    private String userName;
    private List<WatchList> userWatchLists;

}
