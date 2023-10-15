import com.acdat.unit2.MiCopyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        MiCopyFile miCopyFile = new MiCopyFile("c:\\ACDAT\\ejemplo.bmp", "c:\\ACDAT\\salida.bmp");

        if (miCopyFile.CopyTo()) {
            System.out.println(("Archivo copiado correctamente"));
        } else {
            System.out.println("Error al copiar el archivo");
        }
    }
}