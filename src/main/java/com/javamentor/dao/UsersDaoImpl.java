package com.javamentor.dao;

import com.javamentor.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User findByKey(Integer key) {
        return em.find(User.class, key);
    }

    @Override
    public void persist(User entity) {
        em.persist(entity);
    }

    @Override
    public void deleteByKey(Integer key) {
        em.remove(em.find(User.class, key));
    }

    @Override
    public User getUserByUsername(String username) {

        return (User) em.createQuery("SELECT u FROM User u WHERE u.login=:username")
                .setParameter("username", username)
                .getSingleResult();

    }
}
