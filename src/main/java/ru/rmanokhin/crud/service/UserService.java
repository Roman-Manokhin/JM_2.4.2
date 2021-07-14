package ru.rmanokhin.crud.service;

import ru.rmanokhin.crud.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(long id);
    void deleteUser(long id);
    void updateUser(User user);

}
