package com.acdat.unit2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MiFechaConsistente extends MiFecha{

    public MiFechaConsistente() {
        super();
    }

    public MiFechaConsistente(int dia, int mes, int anyo) {
        super(dia, mes, anyo);
    }

    public boolean esBisiesto() {
        boolean respuesta = false;
        //Si es divisible entre 4 y no es divisible entre 100 o es divisible entre 100 y 400.
        if ((this.anyo % 4 == 0 && this.anyo % 100 != 0) || (this.anyo % 100 == 0 && this.anyo % 400 == 0)) {
            respuesta = true;
        }
        return respuesta;
    }

    public boolean esValida() {
        boolean esValida=false;

        try {
            //Formato de fecha (día/mes/año)
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            //Comprobación de la fecha
            formatoFecha.parse(this.dia + "/" + this.mes + "/" + this.anyo);
            esValida = true;
        } catch (ParseException e) {
            //Si la fecha no es correcta, pasará por aquí
            esValida = false;
        }

        return esValida;
    }
}
