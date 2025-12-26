package P7;

import java.util.Scanner;

public class P7_3 {
    
    static int determinant(int[][] m) {
        int det = 0;
        for (int i = 0; i < 5; i++) {
            det += m[0][i] * cofactor(m, 0, i);
        }
        return det;
    }
    
    static int cofactor(int[][] m, int row, int col) {
        int[][] minor = new int[4][4];
        int r = 0, c;

        for (int i = 1; i < 5; i++) {
            c = 0;
            for (int j = 0; j < 5; j++) {
                if (j == col) continue;
                minor[r][c++] = m[i][j];
            }
            r++;
        }
        return ((row + col) % 2 == 0 ? 1 : -1) * det4(minor);
    }

    static int det4(int[][] m) {
        int det = 0;
        for (int i = 0; i < 4; i++)
            det += m[0][i] * (m[1][(i+1)%4]*m[2][(i+2)%4]*m[3][(i+3)%4]
                            - m[1][(i+3)%4]*m[2][(i+2)%4]*m[3][(i+1)%4]);
        return det;
    }

    public static void main(String[] args) {
        System.out.println("Введiть по 1 чiслу кожну строку");

        Scanner sc = new Scanner(System.in);
        int[][] m = new int[5][5];

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                m[i][j] = sc.nextInt();

        System.out.println("Визначник: " + determinant(m));
        sc.close();
    }
}
