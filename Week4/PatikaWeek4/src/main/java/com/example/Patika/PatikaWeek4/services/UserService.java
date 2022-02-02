package com.example.Patika.PatikaWeek4.services;

import com.example.Patika.PatikaWeek4.Movie;
import com.example.Patika.PatikaWeek4.User;
import com.example.Patika.PatikaWeek4.WatchList;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service("us")
public class UserService {

    private List<User> dummyUserList =loadDummyUsers();
    //Method of create users by dummy data
    private List<User> loadDummyUsers(){
        List<User> createUserList = new ArrayList<User>();

        createUserList.add(User.builder()
                        .userId(1L)
                        .userName("Ali Can")
                        .userWatchLists(List.of(WatchList.builder()
                                        .watchListName("List1ofAli")
                                        .watchList(List.of(Movie.builder()
                                                .movieName("The Lord Of The Rings")
                                                .build(),
                                                Movie.builder()
                                                        .movieName("The Fast and Furious")
                                                        .build()))
                                .build(),
                                WatchList.builder()
                                        .watchListName("List2ofAli")
                                        .watchList(List.of(Movie.builder()
                                                        .movieName("The Sweet November")
                                                        .build(),
                                                Movie.builder()
                                                        .movieName("The Notebook")
                                                        .build()))
                                        .build()))
                .build());
        createUserList.add(User.builder()
                        .userId(2L)
                        .userName("Aylin Bayram")
                .userWatchLists(List.of(WatchList.builder()
                                .watchListName("List1ofAylin")
                                .watchList(List.of(Movie.builder()
                                                .movieName("The Fast and Furious")
                                                .build(),
                                        Movie.builder()
                                                .movieName("The Lord of The Rings")
                                                .build()))
                                .build(),
                        WatchList.builder()
                                .watchListName("List2ofAylin")
                                .watchList(List.of(Movie.builder()
                                                .movieName("The Notebook")
                                                .build(),
                                        Movie.builder()
                                                .movieName("The Sweet November")
                                                .build()))
                                .build()))
                .build());
        createUserList.add(User.builder()
                        .userId(3L)
                        .userName("Burak Dal")
                .userWatchLists(List.of(WatchList.builder()
                                .watchListName("List1ofBurak")
                                .watchList(List.of(Movie.builder()
                                                .movieName("The Lord Of The Rings 3")
                                                .build(),
                                        Movie.builder()
                                                .movieName("The Fast and Furious 6")
                                                .build()))
                                .build(),
                        WatchList.builder()
                                .watchListName("List2ofBurak")
                                .watchList(List.of(Movie.builder()
                                                .movieName("Hangover")
                                                .build(),
                                        Movie.builder()
                                                .movieName("Parker")
                                                .build()))
                                .build()))
                .build());

        return createUserList;
    }

    //Method of Add New Watchlist By User
    public void createWatchList(Long userId,String newWatchListName){

       User temp= dummyUserList.stream()
               .filter(usId ->userId==usId.getUserId())
               .findAny()
               .orElse(null);

       temp.getUserWatchLists().add(WatchList.builder()
                       .watchListName(newWatchListName)
               .build());


    }

    //Method of Add a Movie to choosen Watchlist by User
    public void addMovieToWatchList(Long userId,String toAddWatchlistName,String toAddMovieName){

        User temp= dummyUserList.stream()
                .filter(usId ->userId==usId.getUserId())
                .findAny()
                .orElse(null);

            for(WatchList toAdd : temp.getUserWatchLists()){
                if(toAddWatchlistName.equals(toAdd.getWatchListName())){
                    toAdd.getWatchList().add(Movie.builder()
                                    .movieName(toAddMovieName)
                            .build());
                }
            }





    }

}
