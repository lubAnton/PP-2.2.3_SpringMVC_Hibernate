package ru.luboshnikov.springMVC_Hibernate.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.luboshnikov.springMVC_Hibernate.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void editUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(showUser(id));
        entityManager.flush();
    }
}
