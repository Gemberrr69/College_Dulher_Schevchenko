package P14;

import java.util.Scanner;

public class Main {

    static String[] dati = new String[10];
    static String[] zapisi = new String[10];
    static int kilkist = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean rabota = true;

        while (rabota) {
            pokazatMenu();
            String vibor = input.nextLine();

            switch (vibor) {
                case "1":
                    dodatiZapis(input);
                    break;
                case "2":
                    vidaliti(input);
                    break;
                case "3":
                    pokazatiVse();
                    break;
                case "4":
                    rabota = false;
                    System.out.println("Завершення роботи...");
                    break;
                default:
                    System.out.println("Невiрний пункт! Оберiть 1-4.");
            }
        }
    }

    static void pokazatMenu() {
        System.out.println("\n====== Щоденник ======");
        System.out.println("[1] Додати запис");
        System.out.println("[2] Видалити за датою");
        System.out.println("[3] Показати всi записи");
        System.out.println("[4] Вийти");
        System.out.print(">> ");
    }

    static void dodatiZapis(Scanner input) {
        if (kilkist >= 10) {
            System.out.println("Мiсця бiльше немає!");
            return;
        }

        System.out.print("Дата (ДД.ММ.РРРР): ");
        String data = input.nextLine();

        System.out.println("Введiть текст (порожнiй рядок = кiнець):");
        String tekst = "";
        while (true) {
            String ryadok = input.nextLine();
            if (ryadok.isEmpty()) break;
            tekst += ryadok + "\n";
        }

        dati[kilkist] = data;
        zapisi[kilkist] = tekst;
        kilkist++;
        System.out.println("Запис додано!");
    }

    static void pokazatiVse() {
        if (kilkist == 0) {
            System.out.println("[Щоденник порожнiй]");
            return;
        }

        System.out.println("\n====== Усi записи ======");
        for (int i = 0; i < kilkist; i++) {
            System.out.println("Дата: " + dati[i] + " 00:00");
            System.out.println("Текст:\n" + zapisi[i]);
            System.out.println("------------------------");
        }
    }

    static void vidaliti(Scanner input) {
        System.out.print("Дата для видалення: ");
        String shukatiDatu = input.nextLine();
        int pozitsiya = -1;

        for (int i = 0; i < kilkist; i++) {
            if (dati[i].equals(shukatiDatu)) {
                pozitsiya = i;
                break;
            }
        }

        if (pozitsiya != -1) {
            for (int i = pozitsiya; i < kilkist - 1; i++) {
                dati[i] = dati[i + 1];
                zapisi[i] = zapisi[i + 1];
            }
            kilkist--;
            System.out.println("Запис за " + shukatiDatu + " видалено.");
        } else {
            System.out.println("Запис не знайдено.");
        }
    }
}