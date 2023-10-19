package com.acdat.unit2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyPrinterFile {
    public MyPrinterFile() {

    }

    public void imprimir () throws IOException {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter("notas.txt",true));
            double nota = 7.2894;
            String alumno = "José García";
            printWriter.printf("%-30s %3.1f\n", alumno,nota);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
