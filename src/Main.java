import com.acdat.unit2.ArchivoImagen;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner myScanner = new Scanner(System.in);
        ArchivoImagen archivoImagen = new ArchivoImagen();
        System.out.println("Nombre del fichero de imagen: ");

        archivoImagen.setImageFileName(myScanner.next());

        System.out.println(archivoImagen.getFormato());

    }
}