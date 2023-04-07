package ru.luboshnikov.spingMVC_Hibernate.service;

import org.springframework.stereotype.Service;
import ru.luboshnikov.spingMVC_Hibernate.dao.UserDao;
import ru.luboshnikov.spingMVC_Hibernate.dao.UserDaoImpl;
import ru.luboshnikov.spingMVC_Hibernate.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getUsers(){
        return userDao.getUsers();
    }
    @Override
    public void add(User user){
        userDao.add(user);
    }
}
