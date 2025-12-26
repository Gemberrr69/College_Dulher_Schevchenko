package P7;

import java.util.Random;

public class P7_2 {
    public static void main(String[] args) {

        Random rand = new Random();
        int n = 4, m = 4;
        double[][] arr = new double[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = rand.nextDouble() * 100;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 2 == 1 || j % 2 == 1)
                    arr[i][j] = Math.sqrt(arr[i][j]);

                System.out.printf("%6.2f ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
