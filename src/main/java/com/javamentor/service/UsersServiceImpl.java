package com.javamentor.service;

import com.javamentor.dao.UsersDao;
import com.javamentor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<User> getAll() {
        return usersDao.getAll();
    }

    @Override
    public User findByKey(Integer key) {
        return usersDao.findByKey(key);
    }

    @Override
    public void persist(User entity) {
        usersDao.persist(entity);
    }

    @Override
    public void deleteByKey(Integer key) {
        usersDao.deleteByKey(key);
    }

    @Override
    public User getUserByUsername(String username) {

        return usersDao.getUserByUsername(username);

    }

}
