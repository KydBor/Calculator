import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Menu menu = new Menu();
        menu.run();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                break;
            } else {
                System.out.println("Вы ввели неправильный тип значений");
            }
            scanner.nextLine();
        }

    }

}
