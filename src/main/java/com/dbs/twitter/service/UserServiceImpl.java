package com.dbs.twitter.service;

import com.dbs.twitter.model.Tweet;
import com.dbs.twitter.model.User;
import com.dbs.twitter.repository.TweetRepository;
import com.dbs.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, TweetRepository tweetRepository){
        this.userRepository=userRepository;
        this.tweetRepository=tweetRepository;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public List<User> listAll() {
         return this.userRepository.findAll();
    }

    @Override
    @Transactional
    public User findById(long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        this.userRepository.delete(this.userRepository.findById(id).get());
    }

    @Override
    public User saveTweet(long id, Tweet tweet) {
        User user = this.userRepository.findById(id).get();
        user.addTweet(tweet);
        return userRepository.save(user);
    }

    @Override
    public List<Tweet> listAllTweet() {
        return tweetRepository.findAll();
    }


    @Override
    public void deleteTweet(long id) {
        this.tweetRepository.deleteById(id);
    }

    @Override
    public Tweet saveTweet(Tweet tweet){
        return this.tweetRepository.save(tweet);
    }
}
