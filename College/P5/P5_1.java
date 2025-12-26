package P5;

public class P5_1 {

    public static void main(String[] args) {

        double a = 3.15;
        double b = 4;
        double c = 3;

        // x
        double x = (a
                + Math.abs(a / (b * c) + b / (a + c))
                * Math.log(a * a))
                / (20 * a - Math.sqrt(b * b + c * c));

        // y
        double y = a * (Math.atan(c) + Math.exp(b + 1));

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        //плаваюча крапка (6 символiв пiсля крапки)
        System.out.printf("x = %.6f%n", x);
        System.out.printf("y = %.6f%n", y);
    }
}
