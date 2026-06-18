package P17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MiyPerelik perelik = new MiyPerelik();
        Scanner input = new Scanner(System.in);
        boolean rabota = true;

        while (rabota) {
            pokazatMenu();
            String vibor = input.nextLine();

            try {
                switch (vibor) {
                    case "1": {
                        System.out.print("Введiть рядок для додавання: ");
                        perelik.dodaty(input.nextLine());
                        System.out.println("Успiшно додано.");
                    } break;
                    case "2": {
                        System.out.print("Введiть iндекс: ");
                        int indeks = Integer.parseInt(input.nextLine());
                        System.out.print("Введiть рядок: ");
                        perelik.dodaty(indeks, input.nextLine());
                        System.out.println("Елемент вставлено.");
                    } break;
                    case "3": {
                        System.out.print("Введiть iндекс для видалення: ");
                        int indeks = Integer.parseInt(input.nextLine());
                        String vydaleniy = perelik.vydalyty(indeks);
                        System.out.println("Видалено елемент: " + vydaleniy);
                    } break;
                    case "4": {
                        System.out.print("Введiть iндекс: ");
                        int indeks = Integer.parseInt(input.nextLine());
                        System.out.println("Результат: " + perelik.otrymaty(indeks));
                    } break;
                    case "5": {
                        System.out.println("Поточний розмiр: " + perelik.rozmir());
                    } break;
                    case "6": {
                        System.out.println("Усi елементи переліку:");
                        String[] vsi = perelik.vsiElementy();
                        if (vsi.length == 0) {
                            System.out.println("Перелiк порожнiй.");
                        } else {
                            for (int i = 0; i < vsi.length; i++) {
                                System.out.println("[" + i + "] " + vsi[i]);
                            }
                        }
                    } break;
                    case "0": {
                        rabota = false;
                        System.out.println("Завершення роботи...");
                    } break;
                    default:
                        System.out.println("Невiрний пункт! Оберiть 0-6.");
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
        System.out.println("\n====== Перелiк ======");
        System.out.println("[1] Додати елемент в кiнець");
        System.out.println("[2] Додати елемент за iндексом");
        System.out.println("[3] Видалити елемент за iндексом");
        System.out.println("[4] Отримати елемент за iндексом");
        System.out.println("[5] Кiлькiсть елементiв");
        System.out.println("[6] Показати всi елементи");
        System.out.println("[0] Вихiд");
        System.out.print(">> ");
    }
}