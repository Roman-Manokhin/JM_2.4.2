package ru.rmanokhin.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rmanokhin.crud.DAO.UserSecurityDAO;
import ru.rmanokhin.crud.model.UserSecurity;

import java.util.List;

@Service
public class UserSecurityServiceImpl implements UserSecurityService{

    private final UserSecurityDAO userSecurityDAO;

    @Autowired
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public UserSecurityServiceImpl(UserSecurityDAO userSecurityDAO) {
        this.userSecurityDAO = userSecurityDAO;
    }

    @Override
    @Transactional
    public UserSecurity getUserByLogin(String name) {
        return userSecurityDAO.getUserByLogin(name);
    }

    @Override
    @Transactional
    public void addUser(UserSecurity userSecurity) {
        userSecurity.setUserPassword(getPasswordEncoder().encode(userSecurity.getUserPassword()));
        userSecurityDAO.addUser(userSecurity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserSecurity> getAllUsers() {
        return userSecurityDAO.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public UserSecurity getUserById(long id) {
        return userSecurityDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userSecurityDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(UserSecurity userSecurity) {
        if (!userSecurity.getUserPassword().equals(getUserById(userSecurity.getId()).getUserPassword())) {
            userSecurity.setUserPassword(getPasswordEncoder().encode(userSecurity.getUserPassword()));
        }
        userSecurityDAO.updateUser(userSecurity);
    }
}
