package com.example.Patika.PatikaWeek4.controller;

import com.example.Patika.PatikaWeek4.User;
import com.example.Patika.PatikaWeek4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService us;

    //Method for get to user list
    @GetMapping("/users")
    public List<User> userList(){
        return us.getDummyUserList();
    }

    //Method for create a watchlist
    @PostMapping("/users/{userId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addWatchList(@PathVariable("userId") Long userId ,@RequestBody String newListName){

        us.createWatchList(userId, newListName);
    }

    //Method for add a movie to chosen a watchlist
    @PostMapping("/users/{userId}/addMovie")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addMovieToWatchList(@PathVariable("userId") Long userId,@RequestBody String watchListName,String addMovieName){
        us.addMovieToWatchList(userId,watchListName,addMovieName);
    }


}
