package P7;

import java.util.Random;
import java.util.Scanner;

public class P7_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Розмір матриці: ");
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        int[][] t = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                a[i][j] = rand.nextInt(10);
                t[j][i] = a[i][j];
            }

        System.out.println("Транспонована матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(t[i][j] + " ");
            System.out.println();
        }
        sc.close();
    }
}
