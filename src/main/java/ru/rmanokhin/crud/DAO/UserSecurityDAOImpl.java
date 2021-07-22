package ru.rmanokhin.crud.DAO;

import org.springframework.stereotype.Repository;
import ru.rmanokhin.crud.model.UserSecurity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserSecurityDAOImpl implements UserSecurityDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserSecurity getUserByLogin(String login) {
        return (UserSecurity) entityManager.createQuery("from UserSecurity where login = :login")
                .setParameter("login", login).getSingleResult();
    }

    @Override
    public void addUser(UserSecurity userSecurity) {
        entityManager.persist(userSecurity);
    }

    @Override
    public List<UserSecurity> getAllUsers() {
        return entityManager.createQuery("from UserSecurity", UserSecurity.class).getResultList();
    }

    @Override
    public UserSecurity getUserById(long id) {
       return entityManager.find(UserSecurity.class, id);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(UserSecurity userSecurity) {
        entityManager.merge(userSecurity);
    }
}
