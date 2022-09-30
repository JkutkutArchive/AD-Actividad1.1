package ej4.main;

import ej4.model.Asignatura;
import jkutkut.SuperScanner;

import java.io.*;

public class Main {
    private static final int N = 1; // TODO change to 5
    private static final String FILENAME = "res/ej4/asignaturas.dat";
    private static SuperScanner sc;

    public static void main(String[] args) {
        sc = new SuperScanner(System.in);
        Asignatura[] asignaturas = new Asignatura[N];
        for (int i = 0; i < N; i++) {
            asignaturas[i] = askAsignatura();
        }
        sc.close();

        // TODO
        // Crea una clase java que almacene en un fichero binario
        // secuencial ‘asignaturas.dat’ 5 objetos Asignatura (Código asignatura,
        // Nombre, professor, nº de horas).

        // Write
        if (!writeAsignaturas(FILENAME, asignaturas)) {
            System.out.println("Error writing file");
            return;
        }

        // Read
        if (!readDatFile(FILENAME))
            return;
    }

    private static boolean writeAsignaturas(String filename, Asignatura[] asignaturas) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return false;
        }

        // TODO
        return true;
    }

    private static boolean readDatFile(String filename) {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(filename));
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        Asignatura a;
        try {
            a = (Asignatura) ois.readObject();
            while (a != null) {
                System.out.println(a);
                a = (Asignatura) ois.readObject();
            }
        }
        catch (EOFException e) { // End of file
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        try {
            ois.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private static Asignatura askAsignatura() {
        System.out.println("Introduce los datos de la asignatura:");
        return new Asignatura(
            sc.getNatural("Código: "),
            sc.getString("Nombre: "),
            sc.getString("Profesor: "),
            sc.getNatural("Horas: ")
        );
    }
}
