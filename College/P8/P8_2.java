package P8;

import java.util.Scanner;

public class P8_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String text = sc.nextLine();

        char[] chars = text.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }

        System.out.println();
        sc.close();
    }
}
