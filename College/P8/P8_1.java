package P8;

import java.util.Scanner;

public class P8_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String text = sc.nextLine();

        String clean = text.toLowerCase().replaceAll("[^a-zа-я0-9]", "");
        String reversed = new StringBuilder(clean).reverse().toString();

        if (clean.equals(reversed))
            System.out.println("Рядок є паліндромом");
        else
            System.out.println("Рядок не є паліндромом");

        sc.close();
    }
}
