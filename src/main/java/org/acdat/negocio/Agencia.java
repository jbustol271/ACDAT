package org.acdat.negocio;

public class Agencia {
    protected int id;
    protected String nombre;
    protected String direccion;
    protected String telefono;

    public Agencia(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agencia)) return false;

        Agencia agencia = (Agencia) o;

        if (id != agencia.id) return false;
        if (!nombre.equals(agencia.nombre)) return false;
        if (!direccion.equals(agencia.direccion)) return false;
        return telefono.equals(agencia.telefono);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nombre.hashCode();
        result = 31 * result + direccion.hashCode();
        result = 31 * result + telefono.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
