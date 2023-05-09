import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class SelectingChangings {
    public static void selectChangings(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер изменяемого параметра: 1 - Имя, 2 - логин, 3 - паспорт, 4 - добавить роль для user, 5 - изменить роль для user");
        int i = scanner.nextInt();
        LocalDateTime newDate = LocalDateTime.now();
        scanner.nextLine();
        switch (i) {
            case 1:
                System.out.println("Введите новое имя");
                String name = scanner.nextLine();
                user.setName(name);
                user.setDateOfChanging(newDate);
                break;
            case 2:
                System.out.println("Введите новый логин");
                String login = scanner.nextLine();
                user.setLogin(login);
                user.setDateOfChanging(newDate);
                break;
            case 3:
                System.out.println("Введите новый паспорт");
                String password = scanner.nextLine();
                user.setPassword(password);
                user.setDateOfChanging(newDate);
                break;
            case 4:
                System.out.println("Введите id роли");
                int id = scanner.nextInt();
                List<Roles> rolesList = user.getRoles();
                RolesDAO rolesDAO = new RolesDAOImpl();
                rolesList.add(rolesDAO.getRoleById(id));
                user.setRoles(rolesList);
                user.setDateOfChanging(newDate);
                break;
            case 5:
                System.out.println("Введите id роли");
                int id1 = scanner.nextInt();
                List<Roles> rolesList1 = user.getRoles();
                RolesDAO rolesDAO1 = new RolesDAOImpl();
                rolesDAO1.updateRole(rolesDAO1.getRoleById(id1));
                rolesList1.add(rolesDAO1.getRoleById(id1));
                user.setRoles(rolesList1);
                user.setDateOfChanging(newDate);
                break;
        }
    }

    public static void changeRole(Roles role) {
        Scanner scanner = new Scanner(System.in);
        String newRole = scanner.nextLine();
        role.setNameRole(newRole);
    };
}
