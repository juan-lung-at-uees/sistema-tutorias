package edu.uees.tutorias.domain;

public class Estudiante {
    private String id;
    private String nombre;
    private String correo;

    public Estudiante(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }
    public String getCorreo() { return correo; }
    public String getNombre() { return nombre; }
}