package com.acdat.unit2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import static com.acdat.unit2.TiposTelefono.*;

public class MiGestorContactosXML extends DefaultHandler {
    private String contenido;
    private String datosDelContacto;
    private String telefono;
    private TiposTelefono tiposTelefonoGuardado;
    private boolean analizandoTelefonos;

    // Etiqueta de apertura encontrada
    public void startElement(String uri, String nombreLocal,
                             String qName, Attributes atributos) throws SAXException {
        if (qName.equals("telefonos")) {
            analizandoTelefonos = true;
            tiposTelefonoGuardado = TiposTelefono.NINGUNO;
            telefono="";
        }
    }

    // Contenido de la etiqueta, CDATA
    public void characters (char ch[], int inicio, int longitud) throws SAXException {
        contenido = new String(ch, inicio, longitud);
    }

    // Etiqueta de cierre
    public void endElement (String uri, String nombreLocal, String qName) throws SAXException {
        if (!qName.isBlank()) {
            if ( qName.equals("nombre")) {
                datosDelContacto = contenido;
            } else if (qName.equals("apellido")) {
                datosDelContacto += " " + contenido;
            } else if ( analizandoTelefonos && qName.equals("casa") &&
                        tiposTelefonoGuardado == TiposTelefono.NINGUNO) {
                telefono = contenido;
                tiposTelefonoGuardado = CASA;
            } else if ( analizandoTelefonos && qName.equals("trabajo") &&
                    (tiposTelefonoGuardado == CASA || tiposTelefonoGuardado == TiposTelefono.NINGUNO)) {
                telefono = contenido;
                tiposTelefonoGuardado = TRABAJO;
            } else if (analizandoTelefonos && qName.equals("movil")) {
                telefono = contenido;
                tiposTelefonoGuardado = MOVIL;
            } else if (qName.equals("telefonos")) {
                if (!telefono.isBlank()) {
                    datosDelContacto += " - Teléfono: " + telefono;
                    switch (tiposTelefonoGuardado) {
                        case CASA -> datosDelContacto += " (Casa)";
                        case TRABAJO -> datosDelContacto += " (Trabajo)";
                        case MOVIL -> datosDelContacto += " (Móvil)";
                    }
                }
                analizandoTelefonos = false;
            } else if (qName.equals("contacto")) {
                System.out.println(datosDelContacto);
            }
        }
    }
}
