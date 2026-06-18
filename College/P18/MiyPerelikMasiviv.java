package P18;

public class MiyPerelikMasiviv {

    private static final int ROZMIR_BLOKU = 5;

    public static class Vuzol {
        String[] elementy = new String[ROZMIR_BLOKU];
        int kilkist = 0;
        Vuzol nastupniy;

        Vuzol() {}
    }

    private Vuzol golova;
    private int zagalniyRozmir;

    public MiyPerelikMasiviv() {
        golova = new Vuzol();
        zagalniyRozmir = 0;
    }

    public void dodaty(String element) {
        Vuzol potochniy = golova;

        while (potochniy.nastupniy != null) {
            potochniy = potochniy.nastupniy;
        }

        if (potochniy.kilkist == ROZMIR_BLOKU) {
            potochniy.nastupniy = new Vuzol();
            potochniy = potochniy.nastupniy;
        }

        potochniy.elementy[potochniy.kilkist++] = element;
        zagalniyRozmir++;
    }

    public void dodaty(int indeks, String element) {
        if (indeks < 0 || indeks > zagalniyRozmir) {
            throw new IndexOutOfBoundsException("Iндекс: " + indeks + ", розмiр: " + zagalniyRozmir);
        }
        if (indeks == zagalniyRozmir) {
            dodaty(element);
            return;
        }

        Vuzol potochniy = golova;
        int zalyshok = indeks;
        while (zalyshok > potochniy.kilkist) {
            zalyshok -= potochniy.kilkist;
            potochniy = potochniy.nastupniy;
        }

        if (potochniy.kilkist < ROZMIR_BLOKU) {
            System.arraycopy(potochniy.elementy, zalyshok, potochniy.elementy, zalyshok + 1, potochniy.kilkist - zalyshok);
            potochniy.elementy[zalyshok] = element;
            potochniy.kilkist++;
        } else {
            Vuzol noviyVuzol = new Vuzol();
            noviyVuzol.nastupniy = potochniy.nastupniy;
            potochniy.nastupniy = noviyVuzol;

            int seredyna = ROZMIR_BLOKU / 2;
            System.arraycopy(potochniy.elementy, seredyna, noviyVuzol.elementy, 0, ROZMIR_BLOKU - seredyna);
            noviyVuzol.kilkist = ROZMIR_BLOKU - seredyna;
            potochniy.kilkist = seredyna;

            dodaty(indeks, element);
            zagalniyRozmir--;
        }
        zagalniyRozmir++;
    }

    public String vydalyty(int indeks) {
        if (indeks < 0 || indeks >= zagalniyRozmir) {
            throw new IndexOutOfBoundsException("Iндекс: " + indeks + ", розмiр: " + zagalniyRozmir);
        }

        Vuzol potochniy = golova;
        int zalyshok = indeks;
        while (zalyshok >= potochniy.kilkist) {
            zalyshok -= potochniy.kilkist;
            potochniy = potochniy.nastupniy;
        }

        String vydaleniy = potochniy.elementy[zalyshok];

        int skilkyRuhaty = potochniy.kilkist - zalyshok - 1;
        if (skilkyRuhaty > 0) {
            System.arraycopy(potochniy.elementy, zalyshok + 1, potochniy.elementy, zalyshok, skilkyRuhaty);
        }
        potochniy.elementy[--potochniy.kilkist] = null;
        zagalniyRozmir--;

        return vydaleniy;
    }

    public String otrymaty(int indeks) {
        if (indeks < 0 || indeks >= zagalniyRozmir) {
            throw new IndexOutOfBoundsException("Iндекс: " + indeks + ", розмiр: " + zagalniyRozmir);
        }

        Vuzol potochniy = golova;
        int zalyshok = indeks;
        while (zalyshok >= potochniy.kilkist) {
            zalyshok -= potochniy.kilkist;
            potochniy = potochniy.nastupniy;
        }
        return potochniy.elementy[zalyshok];
    }

    public int rozmir() {
        return zagalniyRozmir;
    }

    public int mistkist() {
        int lichylnykVuzliv = 0;
        Vuzol potochniy = golova;
        while (potochniy != null) {
            lichylnykVuzliv++;
            potochniy = potochniy.nastupniy;
        }
        return lichylnykVuzliv * ROZMIR_BLOKU;
    }

    public String[] vsiElementy() {
        String[] vsi = new String[zagalniyRozmir];
        int pozitsiya = 0;
        Vuzol potochniy = golova;
        while (potochniy != null) {
            for (int i = 0; i < potochniy.kilkist; i++) {
                vsi[pozitsiya++] = potochniy.elementy[i];
            }
            potochniy = potochniy.nastupniy;
        }
        return vsi;
    }
}