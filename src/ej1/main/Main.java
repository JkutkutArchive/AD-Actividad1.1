package ej1.main;

import ej1.model.InsertarProductos;
import ej1.model.LeerProducto;
import ej1.model.Producto;
import jkutkut.SuperScanner;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static final int N = 1;
    private static final String FILENAME = "res/ej1/productos.bat";

    private static SuperScanner sc;

    public static void main(String[] args) {
        sc = new SuperScanner(System.in);

        Producto[] productos = new Producto[N];
        for (int i = 0; i < N; i++) {
            productos[i] = askProducto();
        }

        try {
            InsertarProductos.storeProductos(productos, FILENAME);
        }
        catch (FileNotFoundException e) {
            System.out.println(FILENAME + " not found.");
        }
        catch (IOException e) {
            System.out.println("Error with IO when storing the file " + FILENAME);
            e.printStackTrace();
        }

        // Test to verify the objects are stored correctly
        System.out.println("\n\n\nRecovering productos...");
        Producto[] recovered;
        try {
            recovered = LeerProducto.recoverProductos(FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Recovered:");
        for (Producto p : recovered)
            System.out.println(p);
    }

    private static Producto askProducto() {
        System.out.println("Enter the data of the product:");
        return new Producto(
            sc.getNatural("Id: "),
            sc.getString("Name: ", 5, 30),
            sc.getString("Dimensions: "),
            sc.getFloatInRange("Price: ", 0, 1000)
        );
    }
}
