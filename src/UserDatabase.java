public class UserDatabase extends Database{
    private User[] users = new User[1000];
    private int counter = 0;

    @Override
    void save(Object value) {
        User user = (User) value;
        if (isExistUserIn(user)) {
            System.out.println(("Пользователь существует"));
            return;
        } else {
            if (counter < users.length) {
                users[counter] = user;
                counter++;
            } else {
                System.out.println("База данных переполнена");
            }
        }
    }

    @Override
    void printAllInfo() {
// метод не нужен
    }

    private boolean isExistUserIn (User user) {
        for (int i = 0; i < users.length; i++) {
            User currentUser = users[i];
            if (currentUser.getLogin().equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }
}
