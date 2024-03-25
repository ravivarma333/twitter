package com.dbs.twitter.controller;

import com.dbs.twitter.model.Tweet;
import com.dbs.twitter.model.User;
import com.dbs.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TwitterRESTController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> listAll(){
        return this.userService.listAll();
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable("id") long id){
        return this.userService.findById(id);
    }

    @PostMapping("/users")
    public void saveUser(@Valid @RequestBody User user){
        System.out.println("Got a post!");
        this.userService.saveUser(user);
    }

    @GetMapping("/tweets")
    public List<Tweet> listAllTweets(){
        return this.userService.listAllTweet();
    }

    @PostMapping("/tweets")
    public void saveTweet(@RequestBody Tweet tweet){
        System.out.println(tweet);
        System.out.println("Got a tweet");
        this.userService.saveTweet(tweet);
    }
}
