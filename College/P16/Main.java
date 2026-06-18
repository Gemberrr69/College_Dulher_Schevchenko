package P16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MiyVektor vektor = new MiyVektor();
        Scanner input = new Scanner(System.in);
        boolean rabota = true;

        while (rabota) {
            pokazatMenu();
            String vibor = input.nextLine();

            try {
                switch (vibor) {
                    case "1": {
                        System.out.print("Введiть рядок для додавання: ");
                        vektor.dodaty(input.nextLine());
                        System.out.println("Успiшно додано.");
                    } break;
                    case "2": {
                        System.out.print("Введiть iндекс: ");
                        int indeks = Integer.parseInt(input.nextLine());
                        System.out.print("Введiть рядок: ");
                        vektor.dodaty(indeks, input.nextLine());
                        System.out.println("Елемент вставлено.");
                    } break;
                    case "3": {
                        System.out.print("Введiть iндекс для видалення: ");
                        int indeks = Integer.parseInt(input.nextLine());
                        String vydaleniy = vektor.vydalyty(indeks);
                        System.out.println("Видалено елемент: " + vydaleniy);
                    } break;
                    case "4": {
                        System.out.print("Введiть iндекс: ");
                        int indeks = Integer.parseInt(input.nextLine());
                        System.out.println("Результат: " + vektor.otrymaty(indeks));
                    } break;
                    case "5": {
                        System.out.println("Поточний розмiр: " + vektor.rozmir());
                    } break;
                    case "6": {
                        System.out.println("Поточна ємнiсть буфера: " + vektor.yemnist());
                    } break;
                    case "7": {
                        for (int i = 0; i < 10; i++) {
                            vektor.dodaty("яблучкi" + (i + 1));
                        }
                        System.out.println("Новий розмiр: " + vektor.rozmir());
                        System.out.println("Нова ємнiсть: " + vektor.yemnist());
                    } break;
                    case "0": {
                        rabota = false;
                        System.out.println("Завершення роботи...");
                    } break;
                    default:
                        System.out.println("Невiрний пункт! Оберiть 0-7.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Помилка iндексу: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введiть цiле число для iндексу.");
            } catch (Exception e) {
                System.out.println("Виникла помилка: " + e.getMessage());
            }
        }
    }

    static void pokazatMenu() {
        System.out.println("\n====== Вектор ======");
        System.out.println("[1] Додати елемент в кiнець");
        System.out.println("[2] Додати елемент за iндексом");
        System.out.println("[3] Видалити елемент за iндексом");
        System.out.println("[4] Отримати елемент за iндексом");
        System.out.println("[5] Кiлькiсть присутнiх елементiв");
        System.out.println("[6] Кiлькiсть елементiв у буферi");
        System.out.println("[7] Тест");
        System.out.println("[0] Вихiд");
        System.out.print(">> ");
    }
}