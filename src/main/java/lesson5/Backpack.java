package lesson5;

import java.util.*;


public class Backpack {
    private int maxPrice;
    private ArrayList<Thing> thingsForMaxPrices;

    public class Thing {
        int weight;
        int price;

        public Thing(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Thing{weight=" + weight + ", price=" + price + '}';
        }
    }

    public static void main(String[] s) {
        new Backpack().calc();
    }

    public void calc() {
        ArrayList<Thing> things = new ArrayList<>();
        things.add(new Thing(100, 200));
        things.add(new Thing(2, 1));
        things.add(new Thing(3, 300));
        things.add(new Thing(16, 6));
        things.add(new Thing(1, 1000));
        things.add(new Thing(1, 99));
        findMaxPrice(things, 20);
        System.out.println(maxPrice + " " + thingsForMaxPrices);
    }

    private void findMaxPrice(ArrayList<Thing> things, int maxWeight) {
        if (things.size() == 0) {
            return;
        }
        int sumPrice = 0, sumWeight = 0;
        for (Thing t : things) {
            sumPrice = sumPrice + t.price;
            sumWeight = sumWeight + t.weight;
        }
        if (sumWeight <= maxWeight) {
            if (maxPrice < sumPrice) {
                maxPrice = sumPrice;
                thingsForMaxPrices = things;
            }
        } else {
            for (int i = 0; i < things.size(); i++) {
                ArrayList<Thing> subthings = new ArrayList<>(things);
                subthings.remove(i);
                findMaxPrice(subthings, maxWeight);
            }
        }
    }
}