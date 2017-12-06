package com.javamentor.dao;

import com.javamentor.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RolesDaoImpl extends CrudDaoImpl<Role, Integer> implements RolesDao {

    @Override
    public List<Role> getAll() {
        return emf.createEntityManager().createQuery("from Role").getResultList();
    }

    @Override
    public Role findByKey(Integer key) {
        return emf.createEntityManager().find(Role.class, key);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return (Role) emf.createEntityManager().createQuery("SELECT r FROM ROLES AS r WHERE name=:name")
                .setParameter("name", roleName)
                .getSingleResult();
    }

}

