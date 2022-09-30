package ej1.model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeerProducto {
    public static Producto[] recoverProductos(String filename) throws IOException {
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(filename));
        ArrayList<Producto> lst = new ArrayList<Producto>();
        Object p;
        while (true) {
            try {
//                System.out.println("Obtaining Producto");
                p = ios.readObject();
                if (p == null)
                    break;
                if (p instanceof Producto) {
                    lst.add((Producto) p);
//                    System.out.println("Product added to list");
                }
                else
                    throw new ClassNotFoundException("The objects here should be of class Producto");
            }
            catch (EOFException e) { // End of file
//                System.out.println("EOFException: " + e.getMessage());
                break;
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        ios.close();

        // return (Producto[]) lst.toArray(); // This doesn't work
        Producto[] arr = new Producto[lst.size()];
        for (int i = 0; i < lst.size(); i++)
            arr[i] = lst.get(i);
        return arr;
    }
}
