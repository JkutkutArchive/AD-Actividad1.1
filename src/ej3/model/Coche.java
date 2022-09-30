package ej3.model;

public class Coche {
    private String modelo;
    private int aniofabricacion;
    private float precio;

    public Coche(String modelo, int aniofabricacion, float precio) {
        this.modelo = modelo;
        this.aniofabricacion = aniofabricacion;
        this.precio = precio;
    }

    // GETTERS

    public String getModelo() {
        return modelo;
    }

    public int getAniofabricacion() {
        return aniofabricacion;
    }

    public float getPrecio() {
        return precio;
    }

    // SETTERS

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAniofabricacion(int aniofabricacion) {
        this.aniofabricacion = aniofabricacion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // String

    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", aniofabricacion=" + aniofabricacion +
                ", precio=" + precio +
                '}';
    }
}