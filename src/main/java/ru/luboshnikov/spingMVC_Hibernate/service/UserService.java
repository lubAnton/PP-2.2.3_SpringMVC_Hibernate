package ru.luboshnikov.spingMVC_Hibernate.service;

import ru.luboshnikov.spingMVC_Hibernate.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public void add(User user);
}
