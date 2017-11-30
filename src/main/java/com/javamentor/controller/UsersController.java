package com.javamentor.controller;

import com.javamentor.model.User;
import com.javamentor.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("list")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/view")
    public ModelAndView viewUsers() {

        return new ModelAndView("view", "usersList", usersService.getAllUsers());

    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam("id") String userId) {

        return new ModelAndView("edit", "editUser", usersService.find(Integer.parseInt(userId)));

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView processEditUser(@ModelAttribute("editUser") User editUser) {

        usersService.update(editUser.getId(), editUser);
        return new ModelAndView("redirect:view");

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createUser() {

        return new ModelAndView("create", "newUser", new User());

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView processCreateUser(@ModelAttribute("newUser") User newUser) {

        usersService.create(newUser);
        return new ModelAndView("redirect:view");

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam("id") String userId) {

        usersService.delete(usersService.find(Integer.parseInt(userId)));
        return new ModelAndView("redirect:view");

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout() {
        return new ModelAndView("welcome");
    }

}
