package P6;

import java.util.Scanner;

public class P6_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть кількість кутів: ");
        int n = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Введіть кут " + (i + 1) + ": ");
            int angle = sc.nextInt();
            sum += angle;
        }

        int requiredSum = 180 * (n - 2);

        System.out.println("Сума кутів: " + sum);
        System.out.println("Необхідна сума: " + requiredSum);

        if (sum == requiredSum)
            System.out.println("Багатокутник може існувати");
        else
            System.out.println("Багатокутник не може існувати");

        sc.close();
    }
}
