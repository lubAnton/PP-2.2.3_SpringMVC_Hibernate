package ru.luboshnikov.spingMVC_Hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.luboshnikov.spingMVC_Hibernate.model.User;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getUsers() {
        Query query=entityManager.createQuery("from User");
        return query.getResultList();
    }
    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }
}
