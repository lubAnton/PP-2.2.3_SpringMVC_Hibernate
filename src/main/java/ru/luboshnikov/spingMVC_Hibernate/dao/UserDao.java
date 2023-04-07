package ru.luboshnikov.spingMVC_Hibernate.dao;

import ru.luboshnikov.spingMVC_Hibernate.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public void add(User user);
}
