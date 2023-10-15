package com.acdat.unit2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MiCopyFile {

    private String fileInputStreamName;
    private String fileOutputStreamName;

    private FileInputStream fileInputStream = null;
    private FileOutputStream fileOutputStream = null;
    private byte[] datos = new byte[128];

    public String getFileInputStreamName() {
        return fileInputStreamName;
    }

    public void setFileInputStreamName(String fileInputStreamName) {
        this.fileInputStreamName = fileInputStreamName;
    }

    public String getFileOutputStreamName() {
        return fileOutputStreamName;
    }

    public void setFileOutputStreamName(String fileOutputStreamName) {
        this.fileOutputStreamName = fileOutputStreamName;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public FileOutputStream getFileOutputStream() {
        return fileOutputStream;
    }

    public void setFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public byte[] getDatos() {
        return datos;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }

    public MiCopyFile() {
        this.fileOutputStream= null;
        this.fileInputStream = null;
        this.fileInputStreamName = "";
        this.fileOutputStreamName = "";
        // this.datos = null;
    }

    public MiCopyFile (String fileInputStreamName, String fileOutputStreamName) {
        this.fileOutputStream= null;
        this.fileInputStream = null;
        this.fileInputStreamName = fileInputStreamName;
        this.fileOutputStreamName = fileOutputStreamName;
        // this.datos = null;

    }

    public boolean CopyTo () throws IOException {
        boolean copyTo = false;
        int i = 0;
        try {
            this.fileInputStream = new FileInputStream(this.fileInputStreamName);
            this.fileOutputStream = new FileOutputStream(this.fileOutputStreamName);


            while ( (i = this.fileInputStream.read(datos)) != -1 )
                 this.fileOutputStream.write((getDatos()));
            copyTo = true;
        } catch (FileNotFoundException e) {
            copyTo = false; //System.out.println("No se pudo abrir el fichero ( " + e.getMessage() + " )");
        } catch (IOException e) {
            copyTo = false; //System.out.println("Error de entrada/Salida ( " + e.getMessage() + " )");
        } finally {
            fileOutputStream.close();
            fileInputStream.close();
            return copyTo;
        }
    }
}
