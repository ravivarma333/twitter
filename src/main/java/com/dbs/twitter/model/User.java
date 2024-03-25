package com.dbs.twitter.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name cannot be null")
    private String name;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tweet> tweets = new HashSet<>();

    public void addTweet(Tweet tweet){
        this.tweets.add(tweet);
        tweet.setUser(this);
    }

}
