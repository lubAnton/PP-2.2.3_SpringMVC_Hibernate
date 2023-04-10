package ru.luboshnikov.springMVC_Hibernate.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.luboshnikov.springMVC_Hibernate.dao.UserDao;
import ru.luboshnikov.springMVC_Hibernate.dao.UserDaoImpl;
import ru.luboshnikov.springMVC_Hibernate.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();

    @Override
    @Transactional
    public List<User> getUsers(){
        return userDao.getUsers();
    }
    @Override
    @Transactional
    public void add(User user){
        userDao.add(user);
    }
}
