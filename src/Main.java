import com.acdat.unit2.MyPrinterFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        PrintWriter printWriter = null;
        MyPrinterFile myPrinterFile = new MyPrinterFile();

        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("ejemplo.txt",true)));
            printWriter.println("¡Hola!");
            printWriter.println("y ...");
            printWriter.println("¡Hasta pronto");

            myPrinterFile.imprimir();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}