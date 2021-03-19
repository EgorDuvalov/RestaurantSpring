package com.innowise.duvalov.controller;

import com.innowise.duvalov.dao.impl.UserDAOImpl;
import com.innowise.duvalov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passport")
public class PassportController {
    private UserDAOImpl userDAO;

    @Autowired
    public PassportController(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/login")
    public String logIn() {
        return "passport/login";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userDAO.addUser(user);
        return "redirect:welcome";
    }

    @GetMapping("/logup")
    public String logUp(@ModelAttribute("user") User user) {
        return "passport/save";
    }

    @GetMapping("/logout")
    public String logOut() {
        return "passport/logout";
    }
}
