package com.javamentor.dao;

import com.javamentor.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsersDaoImpl extends CrudDaoImpl<User, Integer> implements UsersDao {

    @Override
    public List<User> getAll() {
        return emf.createEntityManager().createQuery("from User").getResultList();
    }

    @Override
    public User findByKey(Integer key) {
        return emf.createEntityManager().find(User.class, key);
    }

    @Override
    public User getUserByUsername(String username) {

        return (User) emf.createEntityManager().createQuery("SELECT u FROM USERS AS u WHERE u.login=:username")
                .setParameter("username", username)
                .getSingleResult();

    }
}
