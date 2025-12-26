package P7;

public class P7_1 {
    public static void main(String[] args) {

        int rows = 5;
        int[][] arr = new int[rows][];

        for (int i = 0; i < rows; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j + 1;
            }
        }

        System.out.println("Звичайна піраміда:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

        System.out.println("Зворотна піраміда:");
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
