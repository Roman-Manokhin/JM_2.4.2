package ru.rmanokhin.crud.DAO;

import ru.rmanokhin.crud.model.UserSecurity;

import java.util.List;

public interface UserSecurityDAO {

    UserSecurity getUserByLogin(String login);

    void addUser(UserSecurity userSecurity);

    List<UserSecurity> getAllUsers();

    UserSecurity getUserById(long id);

    void deleteUser(long id);

    void updateUser(UserSecurity userSecurity);

}
