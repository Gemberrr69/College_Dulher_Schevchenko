package P4;
import java.util.Scanner;

public class P4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        double a = sc.nextDouble();

        System.out.print("Введіть друге число: ");
        double b = sc.nextDouble();

        System.out.print("Введіть оператор (+, -, *, /): ");
        char op = sc.next().charAt(0);

        double result;

        switch (op) {
            case '+':
                result = a + b;
                System.out.println("Результат: " + result);
                break;
            case '-':
                result = a - b;
                System.out.println("Результат: " + result);
                break;
            case '*':
                result = a * b;
                System.out.println("Результат: " + result);
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                    System.out.println("Результат: " + result);
                } else {
                    System.out.println("Помилка: ділення на нуль!");
                }
                break;
            default:
                System.out.println("Невідомий оператор");
        }

        sc.close();
    }
}
