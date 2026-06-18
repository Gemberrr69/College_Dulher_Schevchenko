package P10;

import java.util.Scanner;

public class Main {

    static String[] logins = new String[15];
    static String[] paroli = new String[15];
    static String[] zapretSlova = {"admin", "pass", "password", "qwerty", "ytrewq"};
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean rabota = true;

        while (rabota) {
            System.out.println("\n====== Меню ======");
            System.out.println("Зареєстровано: " + skolkoUsers() + " з 15");
            System.out.println("[1] Новий користувач");
            System.out.println("[2] Видалити користувача");
            System.out.println("[3] Увійти");
            System.out.println("[4] Показати всіх");
            System.out.println("[0] Вийти");
            System.out.print(">> ");

            String vibor = input.nextLine();

            try {
                switch (vibor) {
                    case "1":
                        dobavitUsera();
                        break;
                    case "2":
                        udalitUsera();
                        break;
                    case "3":
                        voiti();
                        break;
                    case "4":
                        spisok();
                        break;
                    case "0":
                        rabota = false;
                        break;
                    default:
                        System.out.println("Такого пункту немає!");
                }
            } catch (IllegalArgumentException err) {
                System.out.println("Помилка: " + err.getMessage());
            } catch (IllegalStateException err) {
                System.out.println("Помилка: " + err.getMessage());
            } catch (IndexOutOfBoundsException err) {
                System.out.println("Помилка: " + err.getMessage());
            } catch (SecurityException err) {
                System.out.println("Доступ заборонено: " + err.getMessage());
            }

            if (!vibor.equals("0")) {
                System.out.println("\n[Enter] - повернутись в меню");
                input.nextLine();
            }
        }

        System.out.println("Програму завершено.");
    }

    static void dobavitUsera() {
        int mesto = naitiMesto();
        if (mesto == -1) {
            throw new IndexOutOfBoundsException("Немає мiсця для нових користувачiв");
        }

        System.out.print("Введiть логiн: ");
        String log = input.nextLine();

        if (log.length() < 5) {
            throw new IllegalArgumentException("Логiн занадто короткий (мiнiмум 5)");
        }
        if (log.contains(" ")) {
            throw new IllegalArgumentException("Логiн не може мiстити пробiли");
        }
        if (uzheEst(log)) {
            throw new IllegalStateException("Такий логiн вже зайнятий");
        }

        System.out.print("Введiть пароль: ");
        String par = input.nextLine();
        proveritParol(par);

        logins[mesto] = log;
        paroli[mesto] = par;
        System.out.println("Користувача додано!");
    }

    static void udalitUsera() {
        System.out.print("Логiн для видалення: ");
        String log = input.nextLine();

        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && logins[i].equals(log)) {
                logins[i] = null;
                paroli[i] = null;
                System.out.println("Видалено!");
                return;
            }
        }
        throw new IllegalArgumentException("Такого користувача не iснує");
    }

    static void voiti() {
        System.out.print("Логiн: ");
        String log = input.nextLine();
        System.out.print("Пароль: ");
        String par = input.nextLine();

        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && logins[i].equals(log)) {
                if (!paroli[i].equals(par)) {
                    throw new SecurityException("Пароль невiрний!");
                }
                System.out.println("Ласкаво просимо, " + log + "!");
                return;
            }
        }
        throw new IllegalArgumentException("Користувача з таким логiном немає");
    }

    static void spisok() {
        System.out.println("\n--- Список ---");
        int nom = 1;
        boolean pusto = true;

        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null) {
                System.out.println(nom + ") " + logins[i]);
                nom++;
                pusto = false;
            }
        }

        if (pusto) {
            System.out.println("Порожньо");
        }
    }

    static void proveritParol(String p) {
        if (p.length() < 10) {
            throw new IllegalArgumentException("Пароль має бути не менше 10 символiв");
        }

        if (p.contains(" ")) {
            throw new IllegalArgumentException("В паролi не може бути пробiлiв");
        }

        String specSimvoli = "!@#$%^&*()_+|}{><?";
        int cifr = 0;
        boolean estSpec = false;

        for (int i = 0; i < p.length(); i++) {
            char s = p.charAt(i);

            boolean bukva = (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z');
            boolean cifra = (s >= '0' && s <= '9');
            boolean spec = false;

            for (int k = 0; k < specSimvoli.length(); k++) {
                if (s == specSimvoli.charAt(k)) {
                    spec = true;
                    break;
                }
            }

            if (!bukva && !cifra && !spec) {
                throw new IllegalArgumentException("Пароль мiстить заборонений символ: " + s);
            }

            if (cifra) cifr++;
            if (spec) estSpec = true;
        }

        if (cifr < 3) {
            throw new IllegalArgumentException("Потрiбно мiнiмум 3 цифри в паролi");
        }
        if (!estSpec) {
            throw new IllegalArgumentException("Потрiбен хоча б 1 спецсимвол");
        }

        String pLower = p.toLowerCase();
        for (int i = 0; i < zapretSlova.length; i++) {
            if (pLower.contains(zapretSlova[i])) {
                throw new IllegalArgumentException("Пароль мiстить заборонене слово: " + zapretSlova[i]);
            }
        }
    }

    static int naitiMesto() {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] == null) return i;
        }
        return -1;
    }

    static int skolkoUsers() {
        int k = 0;
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null) k++;
        }
        return k;
    }

    static boolean uzheEst(String log) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && logins[i].equalsIgnoreCase(log)) {
                return true;
            }
        }
        return false;
    }
}