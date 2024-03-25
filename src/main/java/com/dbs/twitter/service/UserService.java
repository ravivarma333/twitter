package com.dbs.twitter.service;

import com.dbs.twitter.model.Tweet;
import com.dbs.twitter.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserService {
    User saveUser(User user);
    List<User> listAll();
    User findById(long id);
    void deleteUser(long id);

    User saveTweet(long id, Tweet tweet);
    List<Tweet> listAllTweet();
    Tweet saveTweet(Tweet tweet);
    void deleteTweet(long id);
}
