package ru.rmanokhin.crud.DAO;


import ru.rmanokhin.crud.model.Role;

import java.util.List;

public interface RoleDAO {

    void addRole(Role role);
    List<Role> getAllRole();
    void updateRole(Role role);
    Role getRoleByName(String name);
}
