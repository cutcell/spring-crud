package com.javamentor.controller;

import com.javamentor.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/view")
    public ModelAndView view(Model model) {

        return new ModelAndView("view", "usersList", usersService.getAllUsers());

    }

}
