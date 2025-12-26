package P8;

import java.util.Scanner;

public class P8_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть текст: ");
        String line = sc.nextLine().trim();

        String[] words = line.split("\\s+");

        String minWord = words[0];
        String maxWord = words[0];

        for (String w : words) {
            if (w.length() < minWord.length())
                minWord = w;
            if (w.length() > maxWord.length())
                maxWord = w;
        }

        System.out.println("Найкоротше слово: " + minWord + " (" + minWord.length() + ")");
        System.out.println("Найдовше слово: " + maxWord + " (" + maxWord.length() + ")");

        sc.close();
    }
}
