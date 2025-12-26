package P4;
import java.util.Scanner;

public class P4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть ціле число: ");
        int number = sc.nextInt();

        int original = number;
        int reversed = 0;

        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }

        int length = String.valueOf(original).length();

        System.out.printf("Реверс числа: %0" + length + "d%n", reversed);

        sc.close();
    }
}
