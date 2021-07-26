package ru.rmanokhin.crud.DAO;

import org.springframework.stereotype.Repository;
import ru.rmanokhin.crud.model.UserSecurity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserSecurityDAOImpl implements UserSecurityDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserSecurity getUserByLogin(String login) {
        return (UserSecurity) entityManager.createQuery("FROM UserSecurity where login = :login")
                .setParameter("login", login).getSingleResult();
    }

    @Override
    public void addUser(UserSecurity userSecurity) {
        entityManager.persist(userSecurity);
    }

    @Override
    public List<UserSecurity> getAllUsers() {
        return entityManager.createQuery("FROM UserSecurity", UserSecurity.class).getResultList();
    }

    @Override
    public UserSecurity getUserById(long id) {
       return entityManager.find(UserSecurity.class, id);
    }

    @Override
    public void deleteUserById(long id) {
        entityManager.createQuery("DELETE FROM UserSecurity WHERE id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void updateUser(UserSecurity userSecurity) {
        entityManager.merge(userSecurity);
    }
}
