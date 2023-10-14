import com.acdat.unit2.MiFecha;
import com.acdat.unit2.MiFechaConsistente;
import com.acdat.unit2.Persona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner miScanner = new Scanner(System.in);
        Persona persona = new Persona();
        int dia;
        int mes;
        int anyo;

        try {


            System.out.println("Introduce nombre: ");
            persona.setNombre(miScanner.nextLine());
            System.out.println("Introduce apellidos: ");
            persona.setApellidos(miScanner.nextLine());

            dia = readIntValue(miScanner, "día de tú cumpleaños");
            mes = readIntValue(miScanner, "mes de tú cumpleaños");
            anyo = readIntValue(miScanner, "año de tú cumpleaños");

            persona.setMiFechaDeCumpleanyos(new MiFechaConsistente(dia, mes, anyo));

            if (persona.getMiFechaDeCumpleanyos().esValida()) {
                System.out.println("¡Hola, " + persona.getNombre() + " " + persona.getApellidos() + "!");
                System.out.println("Naciste el: " + persona.getMiFechaDeCumpleanyos().getDia() + "/" + persona.getMiFechaDeCumpleanyos().getMes() + "/" + persona.getMiFechaDeCumpleanyos().getAnyo());
                if (persona.getMiFechaDeCumpleanyos().esBisiesto()) {
                    System.out.println("Año bisiesto");
                } else {
                    System.out.println("Año no bisiesto");
                }
            } else {
                System.out.println("La fecha introducida no es válida");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

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
