package P8;

import java.util.Scanner;

public class P8_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть текст: ");
        String text = sc.nextLine();

        String[] banned = { "томат", "демократiя", "трамп" };
        String mask = "***";

        for (String bad : banned) {
            text = text.replace(bad, mask);
            text = text.replace(bad.toLowerCase(), mask);
        }

        System.out.println("Результат: " + text);
        sc.close();
    }
}
