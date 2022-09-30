package ej1.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class InsertarProductos {
    public static void storeProductos(Producto[] arr, String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));

        System.out.println("Storing productos in the file " + filename);

        for (Producto p : arr) {
            // System.out.println(p);
             System.out.print(".");
             oos.writeObject(p);
        }

        System.out.println("\nProductos stored at " + filename);
        oos.close();
    }
}
