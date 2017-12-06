package com.javamentor.dao;

import com.javamentor.model.User;

public interface UsersDao extends CrudDao<User, Integer> {

    User getUserByUsername(String username);

}
