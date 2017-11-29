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
        return usersDao.getUserById(user.getId());
    }

    @Override
    public void create(User newUser) {
        usersDao.insert(newUser);
    }

    @Override
    public void update(User oldUser, User newUser) {
        usersDao.update(oldUser, newUser);
    }

    @Override
    public void delete(User user) {
        usersDao.delete(user);
    }
}
