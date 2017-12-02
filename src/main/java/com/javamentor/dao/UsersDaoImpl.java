package com.javamentor.dao;

import com.javamentor.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    SessionFactory sessionFactory;

    public UsersDaoImpl() {

    }

    @Override
    public List<User> getAllUsers() {

        return getSession().createQuery("from User").list();

    }

    @Override
    public User getUserById(int id) {

        return getSession().find(User.class, id);

    }

    @Override
    public User getUserByLogin(String login) {

        Query qr = getSession().createQuery("from Users u where u.login=:login");
        qr.setParameter("login", login);

        List resultList = qr.getResultList();

        if (resultList.isEmpty()) {
            return null;
        }

        return (User) resultList.get(0);

    }

    @Override
    public void insert(User newUser) {

        getSession().save(newUser);

    }

    @Override
    public void update(int id, User user) {

        User foundUser = getUserById(id);

        foundUser.setLogin(user.getLogin());
        foundUser.setPassword(user.getPassword());
        foundUser.setRole(user.getRole());
        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setEmail(user.getEmail());

        getSession().update(foundUser);

    }

    @Override
    public void delete(int id) {

        getSession().delete(getUserById(id));

    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
