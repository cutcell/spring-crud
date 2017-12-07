package com.javamentor.dao;

import com.javamentor.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RolesDaoImpl implements RolesDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Role> getAll() {
        return em.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public Role findByKey(Integer key) {
        return em.find(Role.class, key);
    }

    @Override
    public void persist(Role entity) {
        em.persist(entity);
    }

    @Override
    public void deleteByKey(Integer key) {
        em.remove(em.find(Role.class, key));
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return (Role) em.createQuery("SELECT r FROM Role r WHERE r.name=:name")
                .setParameter("name", roleName)
                .getSingleResult();
    }

}

