package P7;

import java.util.Random;
import java.util.Scanner;

public class P7_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Розмір матриці: ");
        int n = sc.nextInt();

        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = rand.nextInt(10);

        System.out.print("Рядок для мінору: ");
        int r = sc.nextInt();

        System.out.print("Стовпець для мінору: ");
        int c = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (i == r) continue;
            for (int j = 0; j < n; j++) {
                if (j == c) continue;
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
