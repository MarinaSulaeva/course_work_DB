import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "roles_id")
    private Integer id;

    @Column (name = "name_of_role")
    private String nameRole;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    public Roles() {
    }

    public Roles(String nameRole) {
        this.nameRole = nameRole;
    }

    public Integer getIdRole() {
        return id;
    }

    public void setIdRole(Integer idRole) {
        this.id = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "роль " + nameRole;
    }
}
