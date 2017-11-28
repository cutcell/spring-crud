package com.javamentor.dao;

import com.javamentor.model.User;

import java.util.List;

public interface UsersDao {

    List<User> getAllUsers();

    User getUserById(int id);

    User getUserByLogin(String login);

    void insert(User newUser);

    void update(int id, User user);

    default void update(User updatedUser, User user) {
        update(updatedUser.getId(), user);
    }

    void delete(int id);

    default void delete(User user) {
        delete(user.getId());
    }

}
