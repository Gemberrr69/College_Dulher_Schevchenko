package P6;
import java.util.Scanner;
import java.util.Random;
public class P6_3 {
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Введіть розмір масиву: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(10);
            System.out.print(arr[i] + " ");
        }

        System.out.print("\nЯке число замінити: ");
        int oldValue = sc.nextInt();

        System.out.print("На яке число замінити: ");
        int newValue = sc.nextInt();

        for (int i = 0; i < size; i++) {
            if (arr[i] == oldValue)
                arr[i] = newValue;
        }

        System.out.println("Новий масив:");
        for (int x : arr)
            System.out.print(x + " ");

        sc.close();
    }
}