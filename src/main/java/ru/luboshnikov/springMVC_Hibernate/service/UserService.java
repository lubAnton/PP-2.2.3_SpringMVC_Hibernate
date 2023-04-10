package ru.luboshnikov.springMVC_Hibernate.service;

import ru.luboshnikov.springMVC_Hibernate.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public void add(User user);
}
