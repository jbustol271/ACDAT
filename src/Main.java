import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        int i = 0;

        try {
            fileIn = new FileInputStream("c:\\ACDAT\\ejemplo.bmp");
            fileOut = new FileOutputStream("c:\\ACDAT\\salida.bmp");
            while ( (i=fileIn.read()) != -1 )
                fileOut.write((byte) i );

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir el fichero ( " + e.getMessage() + " )");
        } catch (IOException e) {
            System.out.println("Error de entrada/Salida ( " + e.getMessage() + " )");
        }


    }
}