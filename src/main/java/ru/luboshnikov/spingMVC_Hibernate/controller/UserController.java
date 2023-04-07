package ru.luboshnikov.spingMVC_Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.luboshnikov.spingMVC_Hibernate.service.UserService;
import ru.luboshnikov.spingMVC_Hibernate.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService = new UserServiceImpl();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("allUsers", userService.getUsers());
        return "users";
    }
}
