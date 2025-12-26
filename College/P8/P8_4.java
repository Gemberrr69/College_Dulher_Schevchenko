package P8;

import java.util.Scanner;

public class P8_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String input = sc.nextLine();

        StringBuilder result = new StringBuilder();
        boolean upperNext = false;

        for (char ch : input.toCharArray()) {
            if (ch == '-' || ch == '_') {
                upperNext = true;
            } else {
                if (upperNext) {
                    result.append(Character.toUpperCase(ch));
                    upperNext = false;
                } else {
                    result.append(Character.toLowerCase(ch));
                }
            }
        }

        System.out.println("CamelCase: " + result);
        sc.close();
    }
}
