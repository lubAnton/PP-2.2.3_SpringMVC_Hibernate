package ru.luboshnikov.springMVC_Hibernate;

import ru.luboshnikov.springMVC_Hibernate.model.User;
import ru.luboshnikov.springMVC_Hibernate.service.UserService;
import ru.luboshnikov.springMVC_Hibernate.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName("anton");
        user.setSurname("luboshnikov");
        user.setAge(38);

        userService.add(user);

        }


}
