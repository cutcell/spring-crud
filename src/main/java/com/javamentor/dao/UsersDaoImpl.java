package com.javamentor.dao;

import com.javamentor.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UsersDaoImpl implements UsersDao {

    private List<User> users = new ArrayList<>();

    public UsersDaoImpl() {

        users.add(new User(0, "admin", "admin", "Admin", "", "admin@admin"));
        users.add(new User(1, "user", "", "User", "", "user@user"));

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {

        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(new User());

    }

    @Override
    public User getUserByLogin(String login) {

        return users.stream()
                .filter(u -> u.getLogin() == login)
                .findFirst()
                .orElse(new User());

    }

    @Override
    public void insert(User newUser) {
        users.add(newUser);
    }

    @Override
    public void update(int id, User user) {
        User foundUser = getUserById(id);
        Collections.replaceAll(users, foundUser, user);
    }

    @Override
    public void delete(int id) {
        User foundUser = getUserById(id);
        users.remove(foundUser);
    }
}
