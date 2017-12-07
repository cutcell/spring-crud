package com.javamentor.service;

import com.javamentor.dao.RolesDao;
import com.javamentor.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesDao rolesDao;

    @Override
    public List<Role> getAll() {
        return rolesDao.getAll();
    }

    @Override
    public Role findByKey(Integer key) {
        return rolesDao.findByKey(key);
    }

    @Override
    public void persist(Role entity) {
        rolesDao.persist(entity);
    }

    @Override
    public void deleteByKey(Integer key) {
        rolesDao.deleteByKey(key);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return rolesDao.getRoleByRoleName(roleName);
    }

}