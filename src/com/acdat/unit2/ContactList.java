package com.acdat.unit2;

import java.io.*;
import java.util.ArrayList;

public class ContactList extends ArrayList<Contact> {
    public void readContactFile(String fileName) throws IOException, ClassNotFoundException {
        File miFichero = new File(fileName);
        if (miFichero.exists()) {
            ObjectInputStream objectFichero = new ObjectInputStream(new FileInputStream(miFichero));
            int numObjects = objectFichero.readInt();
            for(;numObjects>0;numObjects--) {
                add((Contact) objectFichero.readObject());
            }
            objectFichero.close();
        }
    }

    public void writeContactFile (String fileName) throws IOException {
        ObjectOutputStream objectFichero = new ObjectOutputStream(new FileOutputStream(fileName));
        objectFichero.writeInt(size());
        for (Contact c: this) {
            objectFichero.writeObject(c);
        }
        objectFichero.close();
    }
}
