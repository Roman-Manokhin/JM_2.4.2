package ru.rmanokhin.crud.DAO;

import ru.rmanokhin.crud.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(long id);
    void deleteUser(long id);
    void updateUser(User updatedUser);


}
