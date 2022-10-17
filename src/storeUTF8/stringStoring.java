package storeUTF8;

import java.io.RandomAccessFile;

public class stringStoring {

    private static final String FILENAME_UTF = "res/storeUTF8/string_utf.dat";
    private static final String FILENAME_LENGTH = "res/storeUTF8/string_length.dat";
    private static final String FILENAME_LENGTH_UTF = "res/storeUTF8/string_length_utf.dat";
    private static final String FILENAME_UTF_CEROS = "res/storeUTF8/string_utf_ceros.dat";
    private static final String STR = "Hello World!";
    private static final int LENGTH = 16;

    public static void main(String[] args) {
        RandomAccessFile fUTF;
        RandomAccessFile fLength;
        RandomAccessFile fLengthUTF;
        RandomAccessFile fUTFceros;

        try {
            fUTF = new RandomAccessFile(FILENAME_UTF, "rw");
            fLength = new RandomAccessFile(FILENAME_LENGTH, "rw");
            fLengthUTF = new RandomAccessFile(FILENAME_LENGTH_UTF, "rw");
            fUTFceros = new RandomAccessFile(FILENAME_UTF_CEROS, "rw");

            fUTF.seek(0);
            fLength.seek(0);
            fLengthUTF.seek(0);
            fUTFceros.seek(0);

            fUTF.writeUTF(STR);
            StringBuffer sb = new StringBuffer(STR);
            sb.setLength(LENGTH);
            fLength.writeChars(sb.toString());
            fLengthUTF.writeUTF(sb.toString());

            fUTFceros.writeUTF(STR);
            for (int i = 0; i < LENGTH - STR.length(); i++) {
                fUTFceros.writeChar(0);
            }

            fUTF.close();
            fLength.close();
            fLengthUTF.close();
            fUTFceros.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(STR);
        System.out.println(STR.length());
        System.out.println("Done.");
    }
}
