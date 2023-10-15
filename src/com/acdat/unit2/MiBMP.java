package com.acdat.unit2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MiBMP {
    private FileInputStream fileInputStream;
    private String fileName;

    private int tamanyo = 0;
    protected int ancho = 0;
    protected int alto = 0;
    protected int intComprimido = 0;
    protected String compresion;
    protected byte[] header = new byte[54];

    public String getCompresion() {

        if (intComprimido==0) {
            return "No comprimido";
        } else if (intComprimido==1) {
            return "RLE-8";
        } else if(intComprimido==4) {
            return "RLE-4";
        }
        return "Error de compresión";
    }

    public int getIntComprimido() {
        return intComprimido;
    }

    public void setIntComprimido(int intComprimido) {
        this.intComprimido = intComprimido;
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public boolean isComprimido() {
        return this.intComprimido == 0;
    }


    public MiBMP(String fileName) {
        this.fileName = fileName;
    }

    public boolean abrirArchivo () {
        boolean respuesta=true;
        try {
            this.fileInputStream = new FileInputStream(this.fileName);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            respuesta = false;
        } finally {
            return respuesta;
        }
    }

    public boolean cerrarArchivo () {
        boolean respuesta = false;
        try {
            this.fileInputStream.close();
        } catch (IOException e) {
            respuesta = false;
        } finally {
            return respuesta;
        }

    }

    public void informacion() {

        try {
            this.fileInputStream.read(this.header, 0, 54);
            this.tamanyo = calcularValor (2,6);
            this.ancho = calcularValor (18,22);
            this.alto = calcularValor (22,26);
            this.intComprimido = calcularValor(30,4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int calcularValor(int inicio, int fin) {
        int valor = 0;
        int potencia = 1;

        for (int i = inicio; i < fin; i++) {
            valor += (this.header[i] & 0xFF) * potencia;
            potencia *= 256;
        }
        return valor;
    }
}
