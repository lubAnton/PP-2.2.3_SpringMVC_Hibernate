package ru.luboshnikov.springMVC_Hibernate.dao;

import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.luboshnikov.springMVC_Hibernate.model.User;

import javax.persistence.EntityManager;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        Query query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
}
