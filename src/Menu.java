import java.util.Scanner;

public class Menu {

    public void Run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 для запуска программы или 2 для выключения");
        do {
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    Calculator calculatorInterfaceImple = new Calculator();
                    calculatorInterfaceImple.calculate();
                    System.out.println("Введите 1 для запуска программы или 2 для выключения");
                    continue;
                case 2:
                    System.out.println("Калькулятор выключен");
            }break;
        }
        while(true);
    }
}

