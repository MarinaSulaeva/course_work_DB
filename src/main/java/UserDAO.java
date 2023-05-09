import java.util.List;

public interface UserDAO {
    void createUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);
}
