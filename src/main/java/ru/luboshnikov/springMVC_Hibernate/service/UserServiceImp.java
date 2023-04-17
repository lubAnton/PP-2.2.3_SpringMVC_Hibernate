package ru.luboshnikov.springMVC_Hibernate.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.luboshnikov.springMVC_Hibernate.dao.UserDao;
import ru.luboshnikov.springMVC_Hibernate.model.User;


import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public User showUser(int id) {
        return userDao.showUser(id);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

}