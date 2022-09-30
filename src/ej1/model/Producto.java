package ej1.model;

import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serialVersionUID = 42L;

    private int id;
    private String nombre;
    private String medidas;
    private float precio;

    public Producto(int id, String nombre, String medidas, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.medidas = medidas;
        this.precio = precio;
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMedidas() {
        return medidas;
    }

    public float getPrecio() {
        return precio;
    }

    // SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // String

    @Override
    public String toString() {
        return "Producto {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", medidas='" + medidas + '\'' +
                ", precio=" + precio +
                '}';
    }
}
