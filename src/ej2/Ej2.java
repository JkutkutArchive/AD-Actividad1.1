package ej2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej2 {
    private static final int END_FILE = -1;
    private static final String FILENAME = "res/ej2/datos.txt";

    public static void main(String[] args) {
        // DEBUG Notas
//        try (FileReader f = new FileReader(FILENAME)) {
//
//        } // Se cierra solo!
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            return;
//        }

        FileReader f;
        try {
            f = new FileReader(FILENAME);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found :S.");
            return;
        }

        try {
            doEj2(f);
        }
        catch (IOException e) {
            System.out.println("Error in IO occurred during the execution of EJ2.");
        }

        try {
            f.close();
        }
        catch (IOException e) {
            System.out.println("Not able to close the file.");
        }
    }

    private static void doEj2(FileReader f) throws IOException {
        char c;
        int i = f.read();
        while (i != END_FILE) {
            c = (char) i;
            if (isLowerVocal(c))
                c = 'a';
            if (isUpperVocal(c))
                c = 'A';
            System.out.print(c);
            i = f.read();
        }
    }

    private static boolean isLowerVocal(char c) {
        if (!(c >= 'a' && c <= 'z'))
            return false;
        for (char v : "aeiou".toCharArray())
            if (v == c)
                return true;
        return false;
    }

    private static boolean isUpperVocal(char c) {
        if (!(c >= 'A' && c <= 'Z'))
            return false;
        for (char v : "AEIOU".toCharArray())
            if (v == c)
                return true;
        return false;
    }
}
