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
                p = ios.readObject();
                if (p instanceof Producto) {
                    System.out.print(".");
                    lst.add((Producto) p);
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

        Producto[] arr = new Producto[0];
        return lst.toArray(arr);

//        Producto[] arr = new Producto[lst.size()];
//        for (int i = 0; i < lst.size(); i++)
//            arr[i] = lst.get(i);
//        return arr;
    }
}
