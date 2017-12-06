package com.javamentor.controller;

import com.javamentor.model.User;
import com.javamentor.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("adm")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/view")
    public String viewUsers(Model model) {

        model.addAttribute("usersList", usersService.getAll());
        return "view";

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable Integer id, Model model) {

        model.addAttribute("user", usersService.findByKey(id));
        return "create-edit";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String processEditUser(@ModelAttribute("user") User user) {

        usersService.update(user);
        return "redirect:view";

    }

    @RequestMapping(value = "/create")
    public String createUser(Model model) {

        model.addAttribute("user", new User());
        return "create-edit";

    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {

        usersService.deleteByKey(id);
        return "redirect:view";

    }

}
