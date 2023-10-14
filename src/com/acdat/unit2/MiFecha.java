package com.acdat.unit2;

public class MiFecha {
    protected int dia;
    protected int mes;
    protected int anyo;

    public MiFecha() {
        this.dia=1;
        this.mes=1;
        this.anyo=0;
    }

    public MiFecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia >= 1 && dia <= 31) {
            this.dia = dia;
        } else {
            throw  new IllegalArgumentException("Valor de día no válido");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            throw new IllegalArgumentException("Valor de mes no válido");
        }
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
}
