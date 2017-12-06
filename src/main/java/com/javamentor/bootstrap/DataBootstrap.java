package com.javamentor.bootstrap;

import com.javamentor.model.Role;
import com.javamentor.model.User;
import com.javamentor.service.RoleService;
import com.javamentor.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleService.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("USER");
        roleService.save(roleUser);

        User admin = new User();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setFirstName("Administrator");
        admin.setEmail("admin@admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleAdmin);
        adminRoles.add(roleUser);
        admin.setRole(adminRoles);

        usersService.save(admin);

        User user = new User();
        user.setLogin("user");
        user.setPassword("user");
        user.setFirstName("User");
        user.setEmail("user@user");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleUser);
        user.setRole(userRoles);

        usersService.save(user);

    }
}
