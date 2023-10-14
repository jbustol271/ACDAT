package com.acdat.unit2;

public class Persona {
    private String nombre;
    private String apellidos;

    private MiFechaConsistente miFechaDeCumpleanyos;

    public MiFechaConsistente getMiFechaDeCumpleanyos() {
        return miFechaDeCumpleanyos;
    }

    public void setMiFechaDeCumpleanyos(MiFechaConsistente miFechaDeCumpleanyos) {
        this.miFechaDeCumpleanyos = miFechaDeCumpleanyos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Persona() {
        this.nombre ="";
        this.apellidos = "";
    }

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
}
