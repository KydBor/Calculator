import java.util.Scanner;

public class Menu {
    int run;
    int exit;

    public Menu(int run, int exit) {
        this.run = run;
        this.exit = exit;
    }

    public void Run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 для запуска программы или 2 для выключения");
        int i = scanner.nextInt();
        if (i == 1) {
        } else if (i != 1) {
            System.out.println("Калькулятор выключен");
            return;
        }

    }

}

