package P9;

import java.util.Scanner;

public class P9_1 {

    // 1) перевірка строки
    static String inputValidString() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Введіть строку: ");
            input = sc.nextLine().trim();

            String[] words = input.split("\\s+");

            if (words.length < 2) {
                System.out.println("Помилка: потрібно мінімум 2 слова");
                continue;
            }

            boolean ok = true;
            for (String w : words) {
                if (w.length() < 3) {
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                System.out.println("Помилка: кожне слово має мати мінімум 3 символи");
            } else {
                break;
            }
        }
        return input;
    }

    // 2) перевернути всю строку
    static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 3) перевернути кожне слово
    static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String w : words) {
            result.append(new StringBuilder(w).reverse()).append(" ");
        }

        return result.toString().trim();
    }

    // 4) Меню
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = inputValidString();

        System.out.println("Оберіть дію:");
        System.out.println("2 — перевернути всю строку");
        System.out.println("3 — перевернути кожне слово");

        int choice = sc.nextInt();

        if (choice == 2) {
            System.out.println("Результат: " + reverseString(text));
        }
        else if (choice == 3) {
            System.out.println("Результат: " + reverseWords(text));
        }
        else {
            System.out.println("Невірний вибір");
        }

        sc.close();
    }
}
