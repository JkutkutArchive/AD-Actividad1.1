package ej4.model;

public class Asignatura {
    private int codigo;
    private String nombre;
    private String profesor;
    private int horas;

    public Asignatura(int codigo, String nombre, String profesor, int horas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
        this.horas = horas;
    }

    // GETTERS

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public int getHoras() {
        return horas;
    }

    // SETTERS

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
