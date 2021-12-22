package lesson5;


public class Pow {

    public static void main(String[] args) {
        System.out.println("pow=" + pow(2, -3));
    }

    static double pow(double num, int exp) {
        double p = powNatural(num, Math.abs(exp));
        return exp < 0 ? 1.0 / p : p;
    }

    static double powNatural(double num, int exp) {
        if (exp == 1) {
            return num;
        }
        return num * powNatural(num, exp - 1);
    }
}
