import java.util.Scanner;

public class Menu {

    private final static String EXIT = "ВЫХОД";
    private final static String HISTORY = "ИСТОРИЯ";
    private final static String COMPLETE = "ЗАВЕРШИТЬ";
    private final static String REGISTRATION = "РЕГИСТРАЦИЯ";
    private final static String AUTHORIZATION = "АВТОРИЗАЦИЯ";
    private Scanner scanner = new Scanner(System.in);
    private CalculatorInterface calculator = new Calculator();

    private User currentUser;

    public void start() {
        System.out.println("Введите АВТОРИЗАЦИЯ для входа, РЕГИСТРАЦИЯ для создания пользователя или ВЫХОД, чтобы" +
                " завершить программу:");
        String string = scanner.nextLine().trim();
        if (REGISTRATION.equalsIgnoreCase(string)) {
            registration();
            verificationOperation();
        } else if (AUTHORIZATION.equalsIgnoreCase(string)) {
            authorization();
            verificationOperation();
        } else if (EXIT.equalsIgnoreCase(string)) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректные данные!");
            start();
        }
    }

    private void registration() {
        while (true) {
            System.out.println("Создайте ЛОГИН:");
            String login = scanner.nextLine().trim();
            if (!"".equals(login) && UserDatabase.getUser(login) == null) {
                System.out.println("Создайте ПАРОЛЬ:");
                String password = scanner.nextLine().trim();
                if (!"".equals(password)) {
                    System.out.println("Создайте ИМЯ:");
                    String name = scanner.nextLine().trim();
                    if (!"".equals(name)) {
                        UserDatabase.setUser(new User(name, login, password));
                        System.out.println("Вы успешно зарегистрировались!");
                        authorization();
                        break;
                    } else {
                        System.out.println("Имя недопустимого формата!");
                    }
                } else {
                    System.out.println("Пароль недопустимого формата!");
                }
            } else {
                System.out.println("Логин недопустимого формата или уже существует!");
            }
        }
    }

    private void authorization() {
        while (true) {
            System.out.println("Ваш ЛОГИН:");
            String login = scanner.nextLine().trim();
            System.out.println("Ваш ПАРОЛЬ:");
            String password = scanner.nextLine().trim();
            User user = UserDatabase.getUser(login);
            if (user != null && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Добро пожаловать, " + currentUser.getName());
                break;
            } else {
                System.out.println("Неверный логин или пароль!");
            }
        }
    }

    private void verificationOperation() {
        while (true) {
            System.out.println("Введите данные для операции, ИСТОРИЯ для просмотра списка результатов или ЗАВЕРШИТЬ," +
                    " чтобы вернуться в основное меню:");
            String firstNumber = scanner.nextLine().trim();
            if (isEqualWithComplete(firstNumber)) {
                start();
                break;
            } else if (isEqualWithHistory(firstNumber)) {
                currentUser.printValues();
                continue;
            }
            String secondNumber = scanner.nextLine().trim();
            if (isEqualWithComplete(secondNumber)) {
                start();
                break;
            } else if (isEqualWithHistory(secondNumber)) {
                currentUser.printValues();
                continue;
            }
            String operation = scanner.nextLine().trim();
            if (isEqualWithComplete(operation)) {
                start();
                break;
            } else if (isEqualWithHistory(operation)) {
                currentUser.printValues();
                continue;
            }
            executeOperation(firstNumber, secondNumber, operation);
        }
    }

    private void executeOperation(String firstNumber, String secondNumber, String operation) {
        if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
            try {
                calculator.operation(currentUser, Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), operation);
            } catch (Exception e) {
                System.out.println("Введите корректные числа!");
            }
        } else {
            System.out.println("Введите корректный оператор!");
        }
    }

    private boolean isEqualWithComplete(String string) {
        return (COMPLETE.equalsIgnoreCase(string));
    }

    private boolean isEqualWithHistory(String string) {
        return (HISTORY.equalsIgnoreCase(string));
    }
}


