package P18;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MiyPerelikMasiviv perelik = new MiyPerelikMasiviv();
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
                        System.out.println("Кiлькiсть елементiв: " + perelik.rozmir());
                    } break;
                    case "6": {
                        System.out.println("Загальна мiсткiсть буфера: " + perelik.mistkist());
                        System.out.println("(Сума всiх комiрок у створених блоках)");
                    } break;
                    case "7": {
                        String[] vsi = perelik.vsiElementy();
                        if (vsi.length == 0) {
                            System.out.println("Список порожнiй.");
                        } else {
                            System.out.println("Весь список:");
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
        System.out.println("\n====== Перелiк Масивiв ======");
        System.out.println("[1] Додати елемент в кiнець");
        System.out.println("[2] Додати елемент за iндексом");
        System.out.println("[3] Видалити елемент за iндексом");
        System.out.println("[4] Отримати елемент за iндексом");
        System.out.println("[5] Кiлькiсть елементiв (size)");
        System.out.println("[6] Мiсткiсть буфера (capacity)");
        System.out.println("[7] Показати всi елементи");
        System.out.println("[0] Вихiд");
        System.out.print(">> ");
    }
}