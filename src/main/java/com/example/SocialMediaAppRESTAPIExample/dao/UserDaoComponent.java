package com.example.SocialMediaAppRESTAPIExample.dao;

import com.example.SocialMediaAppRESTAPIExample.exception.UserNotFoundException;
import com.example.SocialMediaAppRESTAPIExample.model.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoComponent {

    private static List<User> users = new ArrayList<>();
    private static Long usersCount = 0L;

    static {
        users.add(new User(++usersCount, "User 1", Instant.now().minus(30, ChronoUnit.DAYS)));
        users.add(new User(++usersCount, "User 2", Instant.now().minus(25, ChronoUnit.DAYS)));
        users.add(new User(++usersCount, "User 3", Instant.now().minus(20, ChronoUnit.DAYS)));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findUserById(Long id) {
        User foundUser = users.stream().filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElse(null);
        if (foundUser == null) throw new UserNotFoundException("id: " + id);
        return foundUser;
    }

    public User createUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

}