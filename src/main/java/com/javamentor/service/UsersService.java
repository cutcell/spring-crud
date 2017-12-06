package com.javamentor.service;

import com.javamentor.dao.UsersDao;
import com.javamentor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements CrudService<User, Integer> {

    @Autowired
    private UsersDao dao;

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public User findByKey(Integer key) {
        return dao.findByKey(key);
    }

    @Override
    public void update(User entity) {
        dao.update(entity);
    }

    @Override
    public void save(User entity) {
        dao.save(entity);
    }

    @Override
    public void deleteByKey(Integer key) {
        dao.deleteByKey(key);
    }

    public User getUserByUsername(String username) {

        return dao.getUserByUsername(username);

    }

}
