package P6;

import java.util.Random;
import java.util.Scanner;

public class P6_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Введіть розмір масиву: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Заповнення та вивід масиву
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n1 — зростання, 2 — спадання:");
        int choice = sc.nextInt();

        boolean ok = true;

        for (int i = 0; i < n - 1; i++) {
            if (choice == 1 && arr[i] > arr[i + 1]) {
                ok = false;
                break;
            }
            if (choice == 2 && arr[i] < arr[i + 1]) {
                ok = false;
                break;
            }
        }

        if (ok)
            System.out.println("Умова виконується");
        else
            System.out.println("Умова НЕ виконується");

        sc.close();
    }
}
