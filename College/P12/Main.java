package P12;

import java.io.*;
import java.util.Scanner;

public class Main {

    static final String SHLYAH = "C:\\Users\\USER\\Documents\\College\\P12\\text.txt";
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean rabota = true;

        while (rabota) {
            pokazatMenu();
            String vibor = input.nextLine();

            switch (vibor) {
                case "1":
                    zapisatVFile();
                    break;
                case "2":
                    prochitatiFile();
                    break;
                case "3":
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
        System.out.println("[1] Записати текст у файл");
        System.out.println("[2] Показати вмiст файлу");
        System.out.println("[3] Вийти");
        System.out.print(">> ");
    }

    static void zapisatVFile() throws IOException {
        System.out.println("Напишiть рядок для запису:");
        String ryadok = input.nextLine();

        try (FileWriter zapis = new FileWriter(SHLYAH)) {
            zapis.write(ryadok + "\n");
            System.out.println("Текст збережено!");
        } catch (IOException pomilka) {
            System.out.println("Не вдалося записати: " + pomilka.getMessage());
        }

        prochitatiFile();
    }

    static void prochitatiFile() throws IOException {
        try (FileReader chitach = new FileReader(SHLYAH)) {
            int simvol;
            boolean pusto = true;

            while ((simvol = chitach.read()) != -1) {
                System.out.print((char) simvol);
                pusto = false;
            }

            if (pusto) {
                System.out.println("[Файл порожнiй]");
            }
        } catch (IOException pomilka) {
            System.out.println("Не вдалося прочитати: " + pomilka.getMessage());
        }

        System.out.println("\n-------------------");
    }
}