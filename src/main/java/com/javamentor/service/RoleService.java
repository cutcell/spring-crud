package com.javamentor.service;

import com.javamentor.model.Role;

public interface RoleService extends CrudService<Role, Integer> {

    Role getRoleByRoleName(String roleName);

}
