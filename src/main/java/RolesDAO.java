import java.util.List;

public interface RolesDAO {
    void createRoles(Roles role);

    Roles getRoleById(int id);

    List<Roles> getAllRoles();

    List<User> getAllUserByRole(Roles role);

    void updateRole(Roles role);

    void deleteRoles(Roles role);
}
