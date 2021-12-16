package lesson2;

import java.util.Random;

public class Notebook implements Comparable<Notebook> {
    private int price;
    private int ram;
    private String manufacturer;
    public static String[] manufactures = new String[]{"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

    public Notebook(int price, int ram, String manufacturer) {
        this.price = price;
        this.ram = ram;
        this.manufacturer = manufacturer;
    }

    public static Notebook[] getArray(int length) {
        Random random = new Random();

        Notebook[] arr = new Notebook[length];
        arr[0] = new Notebook(500, 4, manufactures[0]);
        for (int i = 1; i < length; i++) {
            arr[i] = new Notebook(
                    500 + random.nextInt(1501) / 50 * 50,
                    4 + random.nextInt(24) / 4 * 4,
                    manufactures[random.nextInt(manufactures.length)]
            );
        }
        return arr;
    }


    @Override
    public String toString() {
        return "Notebook{" + "price=" + price + ", ram=" + ram + ", manufacturer='" + manufacturer + "'" + "}\n";
    }

    @Override
    public int compareTo(Notebook o) {
        int res = price - o.price;
        if (res == 0) {
            res = ram - o.ram;
            if (res == 0)
                return manufacturer.compareTo(o.manufacturer);
        }
        return res;
    }
}
