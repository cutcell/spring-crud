package com.javamentor.service;

import com.javamentor.dao.UsersDao;
import com.javamentor.dao.UsersDaoImpl;
import com.javamentor.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao = new UsersDaoImpl();

    @Override

    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public User find(User user) {
        return find(user.getId());
    }

    @Override
    public User find(int id) {
        return usersDao.getUserById(id);
    }

    @Override
    public void create(User newUser) {
        usersDao.insert(newUser);
    }

    @Override
    public void update(User oldUser, User newUser) {
        update(oldUser.getId(), newUser);
    }

    @Override
    public void update(int id, User newUser) {
        usersDao.update(id, newUser);
    }

    @Override
    public void delete(User user) {
        usersDao.delete(user);
    }
}
