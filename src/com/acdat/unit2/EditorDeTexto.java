package com.acdat.unit2;

import java.io.*;

public class EditorDeTexto {
    protected String fileName;
    protected PrintWriter printWriter;
    protected boolean append = false;
    protected long numeroLineas = 0;
    protected String frase;

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    public long getNumeroLineas() {
        return numeroLineas;
    }

    public void setNumeroLineas(long numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public EditorDeTexto() {
        this.fileName = "";
    }

    public EditorDeTexto(String fileName) {
        this.fileName = fileName;
    }

    public boolean existeFichero () {
        boolean respuesta = false;
        if (new File(this.fileName).exists()) {
            respuesta = true;
        }
        return respuesta;
    }

    public void escribirLinea(){
        printWriter.printf ("%d %s", this.numeroLineas++, this.frase);
        printWriter.println();
    }

    public boolean abrirFichero(String fileName) {
        boolean respuesta = true;
        try {
            setPrintWriter(new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(this.getFileName(),this.isAppend()))));
        } catch (IOException e) {
            respuesta = false;
            e.printStackTrace();
        } finally {
            return respuesta;
        }
    }

    public boolean cerrarFichero() {
        boolean respuesta = false;
        try {
            if (this.printWriter != null) {
                this.printWriter.close();
                respuesta = true;
            }
        } finally {
            return respuesta;
        }
    }
}
