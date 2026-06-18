package P16;

public class MiyVektor {
    private String[] elementy;
    private int rozmir;
    private static final int POCHATKOVA_YEMNIST = 10;

    public MiyVektor() {
        elementy = new String[POCHATKOVA_YEMNIST];
        rozmir = 0;
    }

    public void dodaty(String element) {
        rozshyrytyYakshchoTreba();
        elementy[rozmir++] = element;
    }

    public void dodaty(int indeks, String element) {
        perevirkaIndeksuDlyaDodavannya(indeks);
        rozshyrytyYakshchoTreba();
        System.arraycopy(elementy, indeks, elementy, indeks + 1, rozmir - indeks);
        elementy[indeks] = element;
        rozmir++;
    }

    public String vydalyty(int indeks) {
        perevirkaIndeksu(indeks);
        String vydaleniy = elementy[indeks];
        int skilkyZsunuti = rozmir - indeks - 1;
        if (skilkyZsunuti > 0) {
            System.arraycopy(elementy, indeks + 1, elementy, indeks, skilkyZsunuti);
        }
        elementy[--rozmir] = null;
        return vydaleniy;
    }

    public String otrymaty(int indeks) {
        perevirkaIndeksu(indeks);
        return elementy[indeks];
    }

    public int rozmir() {
        return rozmir;
    }

    public int yemnist() {
        return elementy.length;
    }

    private void rozshyrytyYakshchoTreba() {
        if (rozmir == elementy.length) {
            int novaYemnist = elementy.length * 2;
            String[] noviDani = new String[novaYemnist];
            System.arraycopy(elementy, 0, noviDani, 0, rozmir);
            elementy = noviDani;
            System.out.println("\nБуфер переповнено. Нова ємнiсть: " + novaYemnist);
        }
    }

    private void perevirkaIndeksu(int indeks) {
        if (indeks < 0 || indeks >= rozmir) {
            throw new IndexOutOfBoundsException("Помилка! Iндекс: " + indeks + ", а розмiр вектора: " + rozmir);
        }
    }

    private void perevirkaIndeksuDlyaDodavannya(int indeks) {
        if (indeks < 0 || indeks > rozmir) {
            throw new IndexOutOfBoundsException("Неможливо додати за iндексом " + indeks + " при розмiрi " + rozmir);
        }
    }
}