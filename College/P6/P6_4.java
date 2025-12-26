package P6;

public class P6_4 {
        public static void main(String[] args) {
        int count = 0;

        for (int deg = 0; deg <= 90; deg++) {
            double rad = Math.toRadians(deg);
            double sin = Math.sin(rad);

            System.out.printf("%6.3f ", sin);
            count++;

            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }
    }
}