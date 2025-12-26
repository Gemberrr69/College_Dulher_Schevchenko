package P3;
import java.util.Scanner;
public class P3 {
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть ціле число: ");
        int i = sc.nextInt();

        System.out.print("Введіть число з плаваючою точкою: ");
        double d = sc.nextDouble();

        sc.nextLine();

        System.out.print("Введіть строку: ");
        String s = sc.nextLine();

        System.out.print("Введіть логічне значення (true/false): ");
        boolean b = sc.nextBoolean();

        System.out.println("\n Форматований вивід ");

        System.out.println("1) int (десяткова): " + i);
        System.out.println("2) double: " + d);
        System.out.println("3) string: " + s);

        System.out.printf("4) int (шістнадцяткова): %x%n", i);
        System.out.printf("5) int (вісімкова): %o%n", i);
        System.out.printf("6) double (2 знаки): %.2f%n", d);
        System.out.printf("7) boolean: %b%n", b);

        String f1 = String.format("8) string (ширина 10): %10s", s);
        String f2 = String.format("9) string (обрізка до 3): %.3s", s);
        String f3 = String.format("10) double (ширина 10, 3 знаки): %10.3f", d);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        sc.close();
    }
}