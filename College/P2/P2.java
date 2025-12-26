package P2;
import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {

        // ====== 1) Інформація про примітивні типи ======
        System.out.println("=== Примітивні типи даних ===");

        System.out.println("byte:");
        System.out.println("  Розмір: " + Byte.BYTES + " байт");
        System.out.println("  Мін: " + Byte.MIN_VALUE);
        System.out.println("  Макс: " + Byte.MAX_VALUE);

        System.out.println("short:");
        System.out.println("  Розмір: " + Short.BYTES + " байт");
        System.out.println("  Мін: " + Short.MIN_VALUE);
        System.out.println("  Макс: " + Short.MAX_VALUE);

        System.out.println("int:");
        System.out.println("  Розмір: " + Integer.BYTES + " байт");
        System.out.println("  Мін: " + Integer.MIN_VALUE);
        System.out.println("  Макс: " + Integer.MAX_VALUE);

        System.out.println("long:");
        System.out.println("  Розмір: " + Long.BYTES + " байт");
        System.out.println("  Мін: " + Long.MIN_VALUE);
        System.out.println("  Макс: " + Long.MAX_VALUE);

        System.out.println("float:");
        System.out.println("  Розмір: " + Float.BYTES + " байт");
        System.out.println("  Мін: " + Float.MIN_VALUE);
        System.out.println("  Макс: " + Float.MAX_VALUE);

        System.out.println("double:");
        System.out.println("  Розмір: " + Double.BYTES + " байт");
        System.out.println("  Мін: " + Double.MIN_VALUE);
        System.out.println("  Макс: " + Double.MAX_VALUE);

        System.out.println("char:");
        System.out.println("  Розмір: " + Character.BYTES + " байт");
        System.out.println("  Мін: " + (int) Character.MIN_VALUE);
        System.out.println("  Макс: " + (int) Character.MAX_VALUE);

        System.out.println("boolean:");
        System.out.println("  Розмір: залежить від JVM");
        System.out.println("  Значення: true / false");

        // ====== 2) Зчитування та перетворення ======
        Scanner sc = new Scanner(System.in);

        // int
        System.out.print("\nВведіть значення типу int: ");
        try {
            int i = Integer.parseInt(sc.nextLine());
            System.out.println("Ви ввели int: " + i);
        } catch (NumberFormatException e) {
            System.out.println("Помилка перетворення у int");
        }

        // double
        System.out.print("\nВведіть значення типу double: ");
        try {
            double d = Double.parseDouble(sc.nextLine());
            System.out.println("Ви ввели double: " + d);
        } catch (NumberFormatException e) {
            System.out.println("Помилка перетворення у double");
        }

        // boolean
        System.out.print("\nВведіть значення типу boolean (true/false): ");
        try {
            boolean b = Boolean.parseBoolean(sc.nextLine());
            System.out.println("Ви ввели boolean: " + b);
        } catch (Exception e) {
            System.out.println("Помилка перетворення у boolean");
        }

        // char
        System.out.print("\nВведіть значення типу char: ");
        String line = sc.nextLine();
        if (line.length() == 1) {
            char c = line.charAt(0);
            System.out.println("Ви ввели char: " + c);
        } else {
            System.out.println("Помилка: введіть один символ");
        }

        sc.close();
        
    }
}
