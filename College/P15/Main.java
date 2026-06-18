package P15;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    static String[] dati = new String[10];
    static String[] chasi = new String[10];
    static String[] zapisi = new String[10];
    static int kilkist = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean rabota = true;

        System.out.println("====== Мiй щоденник ======");
        System.out.println("[1] Вiдновити з файлу");
        System.out.println("[2] Створити новий");
        System.out.print(">> ");
        String startVibor = input.nextLine();

        if (startVibor.equals("1")) {
            System.out.print("Шлях до файлу: ");
            zavantazhiti(input.nextLine());
        }

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
                    vihidZiZberezhennyam(input);
                    rabota = false;
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
        String vvedenaData = input.nextLine();

        DateTimeFormatter formatDati = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter formatChasu = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalDate data = LocalDate.parse(vvedenaData, formatDati);
            vvedenaData = data.format(formatDati);
        } catch (DateTimeParseException e) {
            System.out.println("Помилка: некоректний формат дати!");
            return;
        }

        String potochniyChass = LocalTime.now().format(formatChasu);

        System.out.println("Введiть текст (порожнiй рядок = кiнець):");
        String tekst = "";
        while (true) {
            String ryadok = input.nextLine();
            if (ryadok.isEmpty()) break;
            tekst += ryadok + "\n";
        }

        dati[kilkist] = vvedenaData;
        chasi[kilkist] = potochniyChass;
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
            System.out.println("[" + dati[i] + " " + chasi[i] + "]");
            System.out.println(zapisi[i].replace("\\n", "\n"));
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
                chasi[i] = chasi[i + 1];
                zapisi[i] = zapisi[i + 1];
            }
            kilkist--;
            System.out.println("Запис за " + shukatiDatu + " видалено.");
        } else {
            System.out.println("Запис не знайдено.");
        }
    }

    static void vihidZiZberezhennyam(Scanner input) {
        System.out.print("Зберегти данi? (так/нi): ");
        if (input.nextLine().equalsIgnoreCase("так")) {
            System.out.print("Шлях до файлу: ");
            zberegti(input.nextLine());
        }
        System.out.println("Завершення роботи...");
    }

    static void zberegti(String shlyah) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(shlyah))) {
            for (int i = 0; i < kilkist; i++) {
                bw.write(dati[i] + "|" + chasi[i]);
                bw.newLine();
                bw.write(zapisi[i]);
                bw.newLine();
                bw.newLine();
            }
            bw.flush();
            System.out.println("Данi збережено!");
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    static void zavantazhiti(String shlyah) {
        File fail = new File(shlyah);
        if (!fail.exists()) {
            System.out.println("Файл не знайдено!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fail))) {
            kilkist = 0;
            String ryadok;
            while ((ryadok = br.readLine()) != null && kilkist < dati.length) {
                if (ryadok.trim().isEmpty()) continue;

                String[] dataIChas = ryadok.split("\\|");
                if (dataIChas.length == 2) {
                    dati[kilkist] = dataIChas[0];
                    chasi[kilkist] = dataIChas[1];
                }

                String zmist = br.readLine();
                if (zmist != null) {
                    zapisi[kilkist] = zmist;
                    kilkist++;
                }
                br.readLine();
            }
            System.out.println("Вiдновлено записiв: " + kilkist);
        } catch (IOException e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }
    }
}