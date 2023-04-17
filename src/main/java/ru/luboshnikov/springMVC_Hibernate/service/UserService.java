package ru.luboshnikov.springMVC_Hibernate.service;


import ru.luboshnikov.springMVC_Hibernate.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    void save(User user);
    User showUser(int id);
    void editUser(User user);
    void deleteUser(int id);

}