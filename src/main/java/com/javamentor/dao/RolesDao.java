package com.javamentor.dao;

import com.javamentor.model.Role;

public interface RolesDao extends CrudDao<Role, Integer> {

    Role getRoleByRoleName(String roleName);

}
