package com.javamentor.service.security;

import com.javamentor.model.User;
import com.javamentor.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UsersServiceImpl usersService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = usersService.getUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("Not found " + s);
        }

        return user;

    }
}
