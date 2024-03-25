package com.dbs.twitter.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    @Override
    public String toString() {
        return "Tweet{" +
                "tid=" + tid +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return tid == tweet.tid &&
                Objects.equals(message, tweet.message) &&
                Objects.equals(user, tweet.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, message, user);
    }
}
