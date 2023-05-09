import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Integer id;
    @Column (name = "user_name")
    private String name;
    @Column (name = "login")
    private String login;
    @Column (name = "password")
    private String password;
    @Column (name = "date_of_creating")
    private LocalDateTime dateOfCreating;
    @Column (name = "date_of_changing")
    private LocalDateTime dateOfChanging;
    @ManyToMany (fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(
            name = "roles_for_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private List<Roles> roles;

    public User() {
        this.dateOfCreating = LocalDateTime.now();
        this.dateOfChanging = this.dateOfCreating;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.dateOfCreating = LocalDateTime.now();
        this.dateOfChanging = this.dateOfCreating;
    }

    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer userId) {
        this.id = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateOfCreating() {
        return dateOfCreating;
    }

    public void setDateOfCreating(LocalDateTime dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public LocalDateTime getDateOfChanging() {
        return dateOfChanging;
    }

    public void setDateOfChanging(LocalDateTime dateOfChanging) {
        this.dateOfChanging = dateOfChanging;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Пользователь №" + id + ", имя: " + name + ", login: " + login + ", password: " + password + ", " + roles;
    }
}
