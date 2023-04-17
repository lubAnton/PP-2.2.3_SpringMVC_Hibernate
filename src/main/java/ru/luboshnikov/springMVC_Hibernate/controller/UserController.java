package ru.luboshnikov.springMVC_Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.luboshnikov.springMVC_Hibernate.model.User;
import ru.luboshnikov.springMVC_Hibernate.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newPerson (Model model) {
        model.addAttribute("user", new User());
        return "info";
    }
    @PostMapping("/saveUser")
    public String createUser (Model model, @ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            userService.save(user);
        } else {
            userService.editUser(user);
        }
        return "redirect:/";
    }
    @GetMapping("/update")
    public String edit (Model model, @RequestParam int id) {
        model.addAttribute("user", userService.showUser(id));
        return "info";
    }
    @PatchMapping("/update")
    public String update (@RequestParam("id") int id, @RequestBody User user ){
        userService.editUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/deleteUser")
    public String deleteUsers (@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
