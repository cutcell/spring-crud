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
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping({"/", "/home", "/index"})
    public String welcome() {

        return "welcome";

    }

    @RequestMapping(value = "/adm/view")
    public String viewUsers(Model model) {

        model.addAttribute("users", usersService.getAll());
        return "view";

    }

    @RequestMapping(value = "/adm/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {

        model.addAttribute("user", usersService.findByKey(id));
        return "create-edit";

    }

    @RequestMapping(value = "/adm/edit", method = RequestMethod.POST)
    public String processEditUser(@ModelAttribute User user) {

        usersService.persist(user);
        return "redirect:/adm/view";

    }

    @RequestMapping(value = "/adm/create")
    public String createUser(Model model) {

        model.addAttribute("user", new User());
        return "create-edit";

    }

    @RequestMapping(value = "/adm/delete/{id}")
    public String deleteUser(@PathVariable Integer id, Model model) {

        usersService.deleteByKey(id);
        return "redirect:/adm/view";

    }

}
