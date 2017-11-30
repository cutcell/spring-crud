package com.javamentor.service;

import com.javamentor.model.User;

import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    User find(User user);

    User find(int id);

    void create(User newUser);

    void update(User oldUser, User newUser);

    void update(int id, User newUser);

    void delete(User user);

}
