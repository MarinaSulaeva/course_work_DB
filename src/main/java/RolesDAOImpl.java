import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RolesDAOImpl implements RolesDAO{
    EntityManager entityManager = CreatingEntityManager.create();
    @Override
    public void createRoles(Roles role) {
        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.getTransaction().commit();
    }

    @Override
    public Roles getRoleById(int id) {
        entityManager.getTransaction().begin();
        Roles role = entityManager.find(Roles.class, id);
        entityManager.getTransaction().commit();
        return role;
    }

    @Override
    public List<Roles> getAllRoles() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM Roles s";
        TypedQuery<Roles> query = entityManager.createQuery(jpqlQuery, Roles.class);
        List<Roles> rolesList = query.getResultList();
        entityManager.getTransaction().commit();
        return rolesList;
    }

    @Override
    public List<User> getAllUserByRole(Roles role) {
        return role.getUsers();
    }

    @Override
    public void updateRole(Roles role) {
        entityManager.getTransaction().begin();
        Roles role1 = entityManager.find(Roles.class, role.getIdRole());
        SelectingChangings.changeRole(role1);
        entityManager.merge(role1);
        entityManager.getTransaction().commit();
        System.out.println("роль №" + role.getIdRole() + " изменена");
    }

    @Override
    public void deleteRoles(Roles role) {
        entityManager.getTransaction().begin();
        Roles role1 = entityManager.find(Roles.class, role.getIdRole());
        entityManager.remove(role1);
        entityManager.getTransaction().commit();
        System.out.println("роль №" + role.getIdRole() + " удалена");

    }


}
