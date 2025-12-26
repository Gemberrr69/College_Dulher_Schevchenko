package P6;
import java.util.Random;

public class P6_1 {
    public static void main(String[] args) {

        int size = 10;
        int[] arr = new int[size];
        Random rnd = new Random();

        int even = 0, odd = 0;

        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(100);
            System.out.print(arr[i] + " ");

            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("\nПарних: " + even);
        System.out.println("Непарних: " + odd);
    }
}
