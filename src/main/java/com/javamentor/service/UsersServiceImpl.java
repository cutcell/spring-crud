package com.javamentor.service;

import com.javamentor.dao.UsersDao;
import com.javamentor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao dao;

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public User find(User user) {
        return find(user.getId());
    }

    @Override
    public User find(int id) {
        return dao.getUserById(id);
    }

    @Override
    public void create(User newUser) {
        dao.insert(newUser);
    }

    @Override
    public void update(User oldUser, User newUser) {
        update(oldUser.getId(), newUser);
    }

    @Override
    public void update(int id, User newUser) {
        dao.update(id, newUser);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }
}
