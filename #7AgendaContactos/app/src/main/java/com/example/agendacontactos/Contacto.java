package com.example.agendacontactos;

public class Contacto {
    private String nombre;
    private String apellidos;
    private String telefono;

    public Contacto(String nombre, String apellidos, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre +  "\n"+
                "apellidos: " + apellidos +  "\n"+
                "telefono: " + telefono + "\n\n";
    }
}
