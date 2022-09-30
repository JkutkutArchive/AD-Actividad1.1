package ej3.main;

import ej3.model.Coche;

import java.io.RandomAccessFile;
import java.util.Random;

public class Main {
    private static final String FILENAME = "res/ej3/coches.randdat";
    private static final int N = 10;

    // Random values
    private static final String[] BRANDS = {"Abarth", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Cadillac", "Chevrolet", "Chrysler", "Citroën", "Dacia", "Daewoo", "Daihatsu", "Dodge", "Donkervoort", "DS", "Ferrari", "Fiat", "Fisker", "Ford", "Honda", "Hummer", "Hyundai", "Infiniti", "Iveco", "Jaguar", "Jeep", "Kia", "KTM", "Lada", "Lamborghini", "Lancia", "Land Rover", "Landwind", "Lexus", "Lotus", "Maserati", "Maybach", "Mazda", "McLaren", "Mercedes-Benz", "MG", "Mini", "Mitsubishi", "Morgan", "Nissan", "Opel", "Peugeot", "Porsche", "Renault", "Rolls-Royce", "Rover", "Saab", "Seat", "Skoda", "Smart", "SsangYong", "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"};
    private static final String[] MODELS = {"model", "class", "type"};
    private static final int MIN_YEAR = 1935;
    private static final int MAX_YEAR = 2022;
    private static final float MIN_PRICE = 10000;
    private static final float MAX_PRICE = 1000000;

    public static void main(String[] args) {
        Coche[] coches = randomCoches(N);

        for (Coche c : coches) {
            System.out.println(c);
        }

        System.out.println("Guardando coches en fichero...");
        RandomAccessFile f;

        try {
            f = new RandomAccessFile(FILENAME, "rw");
            for (Coche c : coches) {
//                TODO
            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Coche[] randomCoches(int n) {
        Random r = new Random();
        Coche[] coches = new Coche[n];
        for (int i = 0; i < coches.length; i++) {
            coches[i] = randomCoche(r);
        }
        return coches;
    }

    private static Coche randomCoche(Random r) {
        String model = String.format(
            "%s %s %c",
            BRANDS[r.nextInt(BRANDS.length)],
            MODELS[r.nextInt(MODELS.length)],
            "ABCDEG".charAt(r.nextInt(6))
        );
        int year = r.nextInt(MIN_YEAR, MAX_YEAR + 1);
        float price = Math.round(r.nextFloat(MAX_PRICE / MIN_PRICE)) * MIN_PRICE;
        return new Coche(model, year, price);
    }
}
