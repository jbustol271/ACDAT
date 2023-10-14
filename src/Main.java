import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner miScanner = new Scanner(System.in);
        System.out.println("Introduca el nombre del fichero: ");
        String fileName = miScanner.nextLine();
        String respuesta;
        String frase;

        PrintWriter writer = null;

        try {

            boolean append = false;
            long lineNumber = 0;

            if (new File(fileName).exists()) {
                System.out.println("El fichero existe, ¿desea sobreescribirlo (s/n)?");
                respuesta = miScanner.nextLine();
                while (!respuesta.toLowerCase().equals("s") &&
                        !respuesta.toLowerCase().equals("n")) {
                    System.out.println("Por favor, responda (S)í o (N)o ");
                    respuesta = miScanner.nextLine();
                }
                if (respuesta.toLowerCase().equals("n")) {
                    append = true;
                    lineNumber = Files.lines(Paths.get(fileName)).count() + 1;
                }
            }
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName,append)));

            System.out.println("Introduzca una frase a añadir al bloc de notas, <enter> para terminar.");
            frase = miScanner.nextLine();
            while (!frase.isBlank()) {
                writer.printf ("%d %s", lineNumber++, frase);
                writer.println();
                frase = miScanner.nextLine();
            }
            System.out.println("Frases almacenadas en el block de notas.");
        }catch (IOException e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}