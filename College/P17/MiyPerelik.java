package P17;

public class MiyPerelik {

    public static class Vuzol {
        String dani;
        Vuzol nastupniy;

        Vuzol(String dani) {
            this.dani = dani;
            this.nastupniy = null;
        }
    }

    private Vuzol golova;
    private int rozmir;

    public MiyPerelik() {
        this.golova = null;
        this.rozmir = 0;
    }

    public void dodaty(String element) {
        if (golova == null) {
            golova = new Vuzol(element);
        } else {
            Vuzol potochniy = golova;
            while (potochniy.nastupniy != null) {
                potochniy = potochniy.nastupniy;
            }
            potochniy.nastupniy = new Vuzol(element);
        }
        rozmir++;
    }

    public void dodaty(int indeks, String element) {
        if (indeks < 0 || indeks > rozmir) {
            throw new IndexOutOfBoundsException("Неможливо додати за iндексом " + indeks + " при розмiрi " + rozmir);
        }
        if (indeks == 0) {
            Vuzol noviyVuzol = new Vuzol(element);
            noviyVuzol.nastupniy = golova;
            golova = noviyVuzol;
        } else {
            Vuzol poperedniy = znaityVuzolZaIndeksom(indeks - 1);
            Vuzol noviyVuzol = new Vuzol(element);
            noviyVuzol.nastupniy = poperedniy.nastupniy;
            poperedniy.nastupniy = noviyVuzol;
        }
        rozmir++;
    }

    public String vydalyty(int indeks) {
        perevirkaIndeksu(indeks);
        String vydaleniy;

        if (indeks == 0) {
            vydaleniy = golova.dani;
            golova = golova.nastupniy;
        } else {
            Vuzol poperedniy = znaityVuzolZaIndeksom(indeks - 1);
            vydaleniy = poperedniy.nastupniy.dani;
            poperedniy.nastupniy = poperedniy.nastupniy.nastupniy;
        }
        rozmir--;
        return vydaleniy;
    }

    public String otrymaty(int indeks) {
        perevirkaIndeksu(indeks);
        return znaityVuzolZaIndeksom(indeks).dani;
    }

    public int rozmir() {
        return rozmir;
    }

    public String[] vsiElementy() {
        String[] dani = new String[rozmir];
        Vuzol potochniy = golova;
        int i = 0;
        while (potochniy != null) {
            dani[i] = potochniy.dani;
            potochniy = potochniy.nastupniy;
            i++;
        }
        return dani;
    }

    private Vuzol znaityVuzolZaIndeksom(int indeks) {
        Vuzol potochniy = golova;
        for (int i = 0; i < indeks; i++) {
            potochniy = potochniy.nastupniy;
        }
        return potochniy;
    }

    private void perevirkaIndeksu(int indeks) {
        if (indeks < 0 || indeks >= rozmir) {
            throw new IndexOutOfBoundsException("Помилка! Iндекс: " + indeks + ", а розмiр переліку: " + rozmir);
        }
    }
}