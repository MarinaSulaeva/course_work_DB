import java.util.List;

public class Application {
    public static void main(String[] args) {
        //создаем объекты пользователей и ролей и добавляем их в базу данных
        RolesDAO rolesDAO = new RolesDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        User user = new User("Ivan", "ivan1", "123");
        User user1 = new User("Petr", "petr1", "234");
        User user2 = new User("Victor", "victor1", "345");
        User user3 = new User("Anna", "anna1", "456");
        User user4 = new User("Elena", "elena1", "567");
        User user5 = new User("Olga", "olga1", "678");
        User user6 = new User("Nikita", "nikita1", "789");
        User user7 = new User("Alla", "alla1", "890");
        Roles role = new Roles("Разработчик");
        Roles role1 = new Roles("Аналитик");
        Roles role2 = new Roles("Тестировщик");
        Roles role3 = new Roles("Менеджер");
        Roles role4 = new Roles("Дизайнер");
        Roles role5 = new Roles("По умолчанию");
        user.setRoles(List.of(role));
        user1.setRoles(List.of(role1));
        user2.setRoles(List.of(role2, role3));
        user3.setRoles(List.of(role3,role4));
        user4.setRoles(List.of(role4));
        user5.setRoles(List.of(role5,role1));
        user6.setRoles(List.of(role3));
        user7.setRoles(List.of(role, role5));
        rolesDAO.createRoles(role);
        rolesDAO.createRoles(role1);
        rolesDAO.createRoles(role2);
        rolesDAO.createRoles(role3);
        rolesDAO.createRoles(role4);
        rolesDAO.createRoles(role5);
        userDAO.createUser(user);
        userDAO.createUser(user1);
        userDAO.createUser(user2);

//проверяем функционал, необходимый по заданию:
// 1.получение списка пользователей из БД без ролей
// 2.получение конкретного пользователя с ролями
// 3.получение списка пользователей по конкретной роли
// 4.добавлять нового пользователя в БД
// 5.редактировать существующего пользователя в БД
// 6.удалять пользователя БД

        //п.4 функционала
        userDAO.createUser(user3);
        userDAO.createUser(user4);
        userDAO.createUser(user5);
        userDAO.createUser(user6);
        userDAO.createUser(user7);
        //п.1 функционала
        printUserWithoutRoles(userDAO.getAllUsers());
        //п.2 функционала
        System.out.println(userDAO.getUserById(3));
        //п.5 функционала
        userDAO.updateUser(userDAO.getUserById(4));
        //проверка метода изменения пользователя и изменения даты и времени изменения
        System.out.println(userDAO.getUserById(4));
        System.out.println(userDAO.getUserById(4).getDateOfChanging());
        //п.3 функционала
        printUserWithoutRoles(rolesDAO.getAllUserByRole(rolesDAO.getRoleById(1)));
        //п.6 функционала
        userDAO.deleteUser(userDAO.getUserById(9));
        //проверка, что пользователь удален
        printUserWithoutRoles(userDAO.getAllUsers());

        CreatingEntityManager.close();

    }
//метод для печати листа пользователей без ролей
    public static void printUserWithoutRoles(List<User> userList) {
        for (User user : userList) {
            System.out.println("Пользователь №"  + user.getUserId() + " " + user.getName() + ", логин: " + user.getLogin() + ", пароль: " + user.getPassword());
        }
    }
}
