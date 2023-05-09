import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    EntityManager entityManager = CreatingEntityManager.create();
    @Override
    public void createUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUserById(int id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM User s";
        TypedQuery<User> query = entityManager.createQuery(jpqlQuery, User.class);
        List<User> userList = query.getResultList();
        entityManager.getTransaction().commit();
        return userList;
    }

    @Override
    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        User user1 = entityManager.find(User.class, user.getUserId());
        SelectingChangings.selectChangings(user1);
        entityManager.merge(user1);
        entityManager.getTransaction().commit();
        System.out.println("user №" + user.getUserId() + " изменен");


    }

    @Override
    public void deleteUser(User user) {
        entityManager.getTransaction().begin();
        User user1 = entityManager.find(User.class, user.getUserId());
        entityManager.remove(user1);
        entityManager.getTransaction().commit();
        System.out.println("user №" + user.getUserId() + " удален");

    }
}
