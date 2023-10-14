import com.acdat.unit2.Persona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner miScanner = new Scanner(System.in);
        Persona persona = new Persona();

        System.out.println("Introduce nombre: ");
        persona.setNombre(miScanner.nextLine());
        System.out.println("Introduce apellidos: ");
        persona.setApellidos(miScanner.nextLine());

        System.out.println("¡Hola, " + persona.getNombre() + " " + persona.getApellidos()+"!");

    }
}