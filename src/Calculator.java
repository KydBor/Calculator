import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

public class Calculator implements CalculatorInterface {
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        double a = scanner.nextDouble();
        System.out.println("Введите второе число:");
        double b = scanner.nextDouble();
        System.out.println("Укажите операцию:");
        String mathOperation = scanner.next();

        action(a, b, mathOperation);
    }


    @Override
    public void action(double a, double b, String mathOperation) {
        switch (mathOperation) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(a / b);
                break;
            default:
                System.out.println("Нет такой математической операции");
        }
    }

}
