import com.acdat.unit2.Contact;
import com.acdat.unit2.ContactList;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner miScanner;
    private static ContactList contactList;
    private static final String filename = "contacts.obj";

    private static int menu () {
        int opcion = 0;

        System.out.println("MENU");
        System.out.println("====");
        System.out.println();
        System.out.println("1.- Añadir contacto");
        System.out.println("2.- Mostrar lista");
        System.out.println("3.- Buscar contacto");
        System.out.println("0. Terminar");
        while (!miScanner.hasNextInt()) {
            System.out.println("Elige una opción entre 0 y 3, por favor");
            miScanner.next();
        }

        opcion = miScanner.nextInt();
        miScanner.nextLine();
        return opcion;
    }

    public static Contact readContact() {
        Contact contact = new Contact();
        System.out.print("Nombre: ");
        contact.setName(miScanner.nextLine());
        System.out.print("Apellidos: ");
        contact.setSurname(miScanner.nextLine());
        System.out.print("Email: ");
        contact.setEmail(miScanner.nextLine());
        System.out.print("Teléfono: ");
        contact.setPhone(miScanner.nextLine());
        System.out.print("Descripción: ");
        contact.setDescription(miScanner.nextLine());
        System.out.println();

        return contact;
    }

    public static void showContact (Contact contact) {
        System.out.println("Nombre: " + contact.getName());
        System.out.println("Apellidos: " + contact.getSurname());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Teléfono: " + contact.getPhone());
        System.out.print("Descripción: " + contact.getDescription());
        contact.setDescription(miScanner.nextLine());
        System.out.println();
    }

    public static Contact searchContact (){

        String searchType;
        String searchCriteria;
        do {
            System.out.println("¿Busqueda por (N)ombre o por (T)eléfono?");
            searchType = miScanner.next().toLowerCase();
        } while (!searchType.equals("n") && !searchType.equals("t"));

        System.out.println("Dato a buscar: ");
        searchCriteria = miScanner.next();
        for (Contact c: contactList) {
            String searching = searchType.equals("n") ? c.getName() + c.getSurname() : c.getPhone();
            if (searching.contains(searchCriteria)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        contactList = new ContactList();
        miScanner = new Scanner(System.in);
        int opcion= 0 ;

        try {
            contactList.readContactFile(filename);

            opcion = menu();
            while (opcion != 0) {
                switch (opcion) {
                    case 1:
                        contactList.add(readContact());
                        break;
                    case 2:
                        for (Contact contact : contactList) {
                            showContact(contact);
                        }
                        break;
                    case 3:
                        Contact c = searchContact();
                        if (c!= null) {
                            showContact(c);
                        } else {
                            System.out.println("Contacto no encontrado.");
                        }
                }
                opcion = menu();
            }

            contactList.writeContactFile(filename);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}