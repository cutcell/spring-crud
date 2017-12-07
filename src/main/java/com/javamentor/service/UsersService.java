package com.javamentor.service;

import com.javamentor.model.User;

public interface UsersService extends CrudService<User, Integer> {

    User getUserByUsername(String username);

}
