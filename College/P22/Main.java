package P22;

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
        int[] array4 = Arrays.copyOf(array, array.length);
        int[] array5 = Arrays.copyOf(array, array.length);
        int[] array6 = Arrays.copyOf(array, array.length);

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

        LocalTime start4 = LocalTime.now();
        countingSort(array4, ascending);
        LocalTime end4 = LocalTime.now();
        Duration dur4 = Duration.between(start4, end4);

        LocalTime start5 = LocalTime.now();
        mergeSort(array5, ascending);
        LocalTime end5 = LocalTime.now();
        Duration dur5 = Duration.between(start5, end5);

        LocalTime start6 = LocalTime.now();
        quickSort(array6, ascending);
        LocalTime end6 = LocalTime.now();
        Duration dur6 = Duration.between(start6, end6);

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

        System.out.println("\nСортування підрахунком:");
        System.out.println(Arrays.toString(array4));
        System.out.printf("Було відсортовано %d елементів за %d мс (%d нс).\n", size, dur4.toMillis(), dur4.toNanos());

        System.out.println("\nСортування злиттям:");
        System.out.println(Arrays.toString(array5));
        System.out.printf("Було відсортовано %d елементів за %d мс (%d нс).\n", size, dur5.toMillis(), dur5.toNanos());

        System.out.println("\nШвидке сортування:");
        System.out.println(Arrays.toString(array6));
        System.out.printf("Було відсортовано %d елементів за %d мс (%d нс).\n", size, dur6.toMillis(), dur6.toNanos());
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

    public static void countingSort(int[] arr, boolean ascending) {
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int num : arr) {
            if (num < minVal) { minVal = num; }
            if (num > maxVal) { maxVal = num; }
        }

        int range = maxVal - minVal + 1;
        int[] count = new int[range];

        for (int num : arr) {
            count[num - minVal]++;
        }

        int index = 0;
        if (ascending) {
            for (int i = 0; i < count.length; i++) {
                while (count[i] > 0) {
                    arr[index] = i + minVal;
                    index++;
                    count[i]--;
                }
            }
        } else {
            for (int i = count.length - 1; i >= 0; i--) {
                while (count[i] > 0) {
                    arr[index] = i + minVal;
                    index++;
                    count[i]--;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, boolean ascending) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left, ascending);
        mergeSort(right, ascending);

        merge(arr, left, right, ascending);
    }

    public static void merge(int[] result, int[] left, int[] right, boolean ascending) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            boolean takeLeft;
            if (ascending) {
                takeLeft = left[i] <= right[j];
            } else {
                takeLeft = left[i] >= right[j];
            }

            if (takeLeft) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public static void quickSort(int[] arr, boolean ascending) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortInternal(arr, 0, arr.length - 1, ascending);
    }

    private static void quickSortInternal(int[] arr, int low, int high, boolean ascending) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, ascending);
            quickSortInternal(arr, low, pivotIndex - 1, ascending);
            quickSortInternal(arr, pivotIndex + 1, high, ascending);
        }
    }

    private static int partition(int[] arr, int low, int high, boolean ascending) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            boolean shouldSwap;
            if (ascending) {
                shouldSwap = arr[j] < pivot;
            } else {
                shouldSwap = arr[j] > pivot;
            }

            if (shouldSwap) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}