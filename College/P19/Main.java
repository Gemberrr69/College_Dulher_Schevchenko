package P19;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        System.out.print("Введіть мінімальне значення діапазону: ");
        int min = scanner.nextInt();

        System.out.print("Введіть максимальне значення діапазону: ");
        int max = scanner.nextInt();

        if (min > max) {
            System.out.println("Помилка: мінімальне значення не може бути більшим за максимальне.");
            return;
        }

        System.out.print("Виберіть спосіб сортування (1 - за зростанням, 2 - за спаданням): ");
        int choice = scanner.nextInt();
        boolean ascending;
        if (choice == 1) { ascending = true; } else { ascending = false; }

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }

        System.out.println("\nМасив до сортування:");
        System.out.println(Arrays.toString(array));

        LocalTime startTime = LocalTime.now();

        sort(array, ascending);

        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        long nanos = duration.toNanos();
        long millis = duration.toMillis();

        System.out.println("\nМасив після сортування:");
        System.out.println(Arrays.toString(array));
        System.out.printf("\nБуло відсортовано %d елементів за %d мс (%d нс).\n", size, millis, nanos);
    }

    public static void sort(int[] arr, boolean ascending) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                boolean shouldSwap = false;

                if (ascending) {
                    if (arr[j] > arr[j + 1]) { shouldSwap = true; }
                } else {
                    if (arr[j] < arr[j + 1]) { shouldSwap = true; }
                }

                if (shouldSwap) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) { break; }
        }
    }
}