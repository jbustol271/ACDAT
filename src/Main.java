import com.acdat.unit2.MiFecha;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int dia;
        int mes;
        int anyo;
        
        dia = readIntValue(myScanner,"día");
        mes = readIntValue(myScanner,"mes");
        anyo = readIntValue(myScanner,"año");

        try {
            MiFecha miFecha = new MiFecha(dia, mes, anyo);
            anyo = readIntValue(myScanner, "otro año");
            miFecha.setAnyo(anyo);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Hello world!");
    }

    private static int readIntValue(Scanner myScanner, String valor) {
        System.out.println("Introduzca el " + valor + ": ");
        while (myScanner.hasNextInt() == false ) {
            System.out.println("El valor debe ser un entero");
            myScanner.next();
        }
        return myScanner.nextInt();
    }
}