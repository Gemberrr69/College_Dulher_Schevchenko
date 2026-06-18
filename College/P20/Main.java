package P20;

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

        int[] array1 = Arrays.copyOf(array, array.length);
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = Arrays.copyOf(array, array.length);

        System.out.println("\nМасив до сортування:");
        System.out.println(Arrays.toString(array));

        LocalTime start1 = LocalTime.now();
        bubbleSort(array1, ascending);
        LocalTime end1 = LocalTime.now();
        Duration dur1 = Duration.between(start1, end1);

        LocalTime start2 = LocalTime.now();
        selectionSort(array2, ascending);
        LocalTime end2 = LocalTime.now();
        Duration dur2 = Duration.between(start2, end2);

        LocalTime start3 = LocalTime.now();
        insertionSort(array3, ascending);
        LocalTime end3 = LocalTime.now();
        Duration dur3 = Duration.between(start3, end3);

        System.out.println("\nМасив після сортування:\n");

        System.out.println("Бульбашкове сортування:");
        System.out.println(Arrays.toString(array1));
        System.out.printf("Було відсортовано %d елементів за %d мс (%d нс).\n", size, dur1.toMillis(), dur1.toNanos());

        System.out.println("\nВибіркове сортування:");
        System.out.println(Arrays.toString(array2));
        System.out.printf("Було відсортовано %d елементів за %d мс (%d нс).\n", size, dur2.toMillis(), dur2.toNanos());

        System.out.println("\nСортування вставкою:");
        System.out.println(Arrays.toString(array3));
        System.out.printf("Було відсортовано %d елементів за %d мс (%d нс).\n", size, dur3.toMillis(), dur3.toNanos());
    }

    public static void bubbleSort(int[] arr, boolean ascending) {
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

    public static void selectionSort(int[] arr, boolean ascending) {
        for (int i = 0; i < arr.length - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (ascending) {
                    if (arr[j] < arr[targetIndex]) { targetIndex = j; }
                } else {
                    if (arr[j] > arr[targetIndex]) { targetIndex = j; }
                }
            }
            int temp = arr[targetIndex];
            arr[targetIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr, boolean ascending) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            if (ascending) {
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
            } else {
                while (j >= 0 && arr[j] < key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
            }
            arr[j + 1] = key;
        }
    }
}