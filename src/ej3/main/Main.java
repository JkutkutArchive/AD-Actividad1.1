package ej3.main;

import ej3.model.Coche;
import jkutkut.ByteUtils;
import jkutkut.InvalidDataException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Main {
    private static final String FILENAME = "res/ej3/coches.randdat";
    private static final int N = 10;

    // Random values
    private static final String[] BRANDS = {"Audi", "Bentley", "BMW", "Bugatti", "Cadillac", "Chevrolet", "Chrysler", "Citroën", "Dacia", "DS", "Ferrari", "Fiat", "Fisker", "Ford", "Honda", "Hummer", "Hyundai", "Jaguar", "Jeep", "Kia", "KTM", "Lada", "Lancia", "Land Rover", "Landwind", "Lexus", "Lotus", "Maserati", "Maybach", "Mazda", "McLaren", "MG", "Mini", "Mitsubishi", "Morgan", "Nissan", "Opel", "Peugeot", "Porsche", "Renault", "Rolls-Royce", "Rover", "Saab", "Seat", "Skoda", "Smart", "SsangYong", "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"};
    private static final String[] MODELS = {"model", "class", "type"};
    private static final int MIN_YEAR = 1935;
    private static final int MAX_YEAR = 2022;
    private static final float MIN_PRICE = 10000;
    private static final float MAX_PRICE = 1000000;

    public static void main(String[] args) {
        Coche[] coches = randomCoches(N);

        System.out.println("Guardando coches en fichero...");
        RandomAccessFile f;

        try {
            f = new RandomAccessFile(FILENAME, "rwd");
            f.seek(0);
            for (Coche c : coches) {
                writeCoche(f, c);
            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Leyendo coches del fichero...");

        try {
            f = new RandomAccessFile(FILENAME, "r");
            f.seek(0);
            Coche[] coches2 = new Coche[N];
            for (int i = 0; i < N; i++) {
                coches2[i] = readCoche(f);
                if (!coches2[i].equals(coches[i])) {
                    System.err.println("Error: coches no coinciden en i = " + i);
                    System.err.println("  " + coches[i]);
                    System.err.println("  " + coches2[i]);
                    throw new InvalidDataException("Error: coches no coinciden en i = " + i);
                }
            }
            f.close();

            System.out.println("Coches leídos correctamente.");
            for (Coche c : coches) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeCoche(RandomAccessFile f, Coche c) throws IOException {
        StringBuffer sb = new StringBuffer(c.getModelo());
        sb.setLength(Coche.MODEL_MAX_LENGTH);
        f.writeUTF(sb.toString());
        f.writeInt(c.getAniofabricacion());
        f.writeFloat(c.getPrecio());
    }

    private static Coche readCoche(RandomAccessFile f) throws IOException {
        String modelo = f.readUTF().trim();
        int anio = f.readInt();
        float precio = f.readFloat();
        return new Coche(modelo, anio, precio);
    }


    // Random generator
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
//        return new Coche("test", year, price);
        return new Coche(model, year, price);
    }
}
