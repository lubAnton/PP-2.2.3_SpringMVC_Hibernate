package ru.luboshnikov.springMVC_Hibernate.dao;

import ru.luboshnikov.springMVC_Hibernate.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public void add(User user);
}
