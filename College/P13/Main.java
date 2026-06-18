package P13;

import java.io.*;
import java.util.Scanner;

public class Main {

    static final String SHLYAH = "C:\\Users\\USER\\Documents\\College\\P13\\text.txt";
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean rabota = true;

        while (rabota) {
            pokazatMenu();
            String vibor = input.nextLine();

            switch (vibor) {
                case "1":
                    zapisatRyadki();
                    break;
                case "2":
                    pokazatiVse();
                    break;
                case "3":
                    pokazatiDiapazon();
                    break;
                case "4":
                    vstavitRyadok();
                    break;
                case "5":
                    System.out.println("Завершення роботи...");
                    rabota = false;
                    break;
                default:
                    System.out.println("Невiрний пункт! Спробуйте знову.");
            }
        }
    }

    static void pokazatMenu() {
        System.out.println("\n====== Редактор ======");
        System.out.println("[1] Додати кiлька рядкiв");
        System.out.println("[2] Вивести весь файл");
        System.out.println("[3] Вивести рядки за дiапазоном");
        System.out.println("[4] Вставити у конкретний рядок");
        System.out.println("[5] Вийти");
        System.out.print(">> ");
    }

    static void zapisatRyadki() {
        System.out.println("Скiльки рядкiв додати?");
        try {
            int kilkist = Integer.parseInt(input.nextLine());

            try (BufferedWriter zapis = new BufferedWriter(new FileWriter(SHLYAH, true))) {
                for (int i = 0; i < kilkist; i++) {
                    System.out.print((i + 1) + " | ");
                    zapis.write(input.nextLine());
                    zapis.newLine();
                }
                System.out.println("Текст збережено!");
            }
        } catch (NumberFormatException | IOException pomilka) {
            System.out.println("Помилка: " + pomilka.getMessage());
        }
    }

    static void pokazatiVse() {
        try (BufferedReader chitach = new BufferedReader(new FileReader(SHLYAH))) {
            String ryadok;
            boolean pusto = true;
            int nomer = 1;

            System.out.println("\n====== Вмiст файлу ======");

            while ((ryadok = chitach.readLine()) != null) {
                System.out.println(nomer + " | " + ryadok);
                pusto = false;
                nomer++;
            }

            if (pusto) {
                System.out.println("[Файл порожнiй]");
            }
        } catch (IOException pomilka) {
            System.out.println("Не вдалося прочитати: " + pomilka.getMessage());
        }
    }

    static void pokazatiDiapazon() {
        try {
            System.out.print("Вiд рядка: ");
            int vid = Integer.parseInt(input.nextLine());
            System.out.print("До рядка: ");
            int doo = Integer.parseInt(input.nextLine());
            boolean pusto = true;

            try (BufferedReader chitach = new BufferedReader(new FileReader(SHLYAH))) {
                String ryadok;
                int pozitsiya = 1;

                while ((ryadok = chitach.readLine()) != null) {
                    if (pozitsiya >= vid && pozitsiya <= doo) {
                        System.out.println(pozitsiya + " | " + ryadok);
                        pusto = false;
                    }
                    pozitsiya++;
                }

                if (pusto) {
                    System.out.println("[Нiчого не знайдено]");
                }
            }
        } catch (Exception pomilka) {
            System.out.println("Помилка дiапазону: " + pomilka.getMessage());
        }
    }

    static void vstavitRyadok() {
        try {
            int vsogoRyadkiv = 0;

            try (BufferedReader chitach = new BufferedReader(new FileReader(SHLYAH))) {
                while (chitach.readLine() != null) {
                    vsogoRyadkiv++;
                }
            }

            System.out.print("Номер рядка для вставки (1-" + (vsogoRyadkiv + 1) + "): ");
            int kuda = Integer.parseInt(input.nextLine());
            System.out.print("Текст: ");
            String noviyText = input.nextLine();

            String[] zmist = new String[vsogoRyadkiv];

            try (BufferedReader chitach = new BufferedReader(new FileReader(SHLYAH))) {
                for (int i = 0; i < vsogoRyadkiv; i++) {
                    zmist[i] = chitach.readLine();
                }
            }

            try (BufferedWriter zapis = new BufferedWriter(new FileWriter(SHLYAH))) {
                boolean vstavleno = false;

                for (int i = 0; i < vsogoRyadkiv; i++) {
                    if (i + 1 == kuda) {
                        zapis.write(noviyText);
                        zapis.newLine();
                        vstavleno = true;
                    }
                    zapis.write(zmist[i]);
                    zapis.newLine();
                }

                if (!vstavleno) {
                    zapis.write(noviyText);
                    zapis.newLine();
                }
            }

            System.out.println("Вставку виконано!");

        } catch (IOException | NumberFormatException pomilka) {
            System.out.println("Помилка: " + pomilka.getMessage());
        }
    }
}