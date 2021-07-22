package ru.rmanokhin.crud.DAO;

import org.springframework.stereotype.Repository;
import ru.rmanokhin.crud.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public List<Role> getAllRole() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("from Role where name = :name")
                .setParameter("name", name).getSingleResult();
    }
}
