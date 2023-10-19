import com.acdat.unit2.EditorDeTexto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            miMain();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

  /*      Scanner miScanner = new Scanner(System.in);
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
        } */
    }

    public static void miMain() throws IOException {
        Scanner miScanner = new Scanner(System.in);
        EditorDeTexto editorDeTexto = new EditorDeTexto();
        String respuesta;

        try {
            System.out.println("Introduca el nombre del fichero: ");
            editorDeTexto.setFileName(miScanner.nextLine());
            if (editorDeTexto.existeFichero()) {
                System.out.println("El fichero existe, ¿desea sobreescribirlo (s/n)?");
                respuesta = miScanner.nextLine();
                while (!respuesta.toLowerCase().equals("s") &&
                        !respuesta.toLowerCase().equals("n")) {
                    System.out.println("Por favor, responda (S)í o (N)o ");
                    respuesta = miScanner.nextLine();
                }
                if (respuesta.toLowerCase().equals("n")) {
                    editorDeTexto.setAppend(true);
                    editorDeTexto.setNumeroLineas(Files.lines(Paths.get(editorDeTexto.getFileName())).count() + 1);
                }
            }

            if (editorDeTexto.abrirFichero(editorDeTexto.getFileName())) {
                System.out.println("Introduzca una frase a añadir al bloc de notas, <enter> para terminar.");
                editorDeTexto.setFrase(miScanner.nextLine());
                while (!editorDeTexto.getFrase().isBlank()) {
                    editorDeTexto.escribirLinea();
                    editorDeTexto.setFrase(miScanner.nextLine());
                }
                System.out.println("Frases almacenadas en el block de notas.");
            }
        } finally {
            editorDeTexto.cerrarFichero();
        }

    }
}