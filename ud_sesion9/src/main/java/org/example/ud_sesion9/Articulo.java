package org.example.ud_sesion9;

public class Articulo {
    private String nombre;
    private Double precio;
    private Boolean agotado;

    public Articulo(String nombre, Double precio, Boolean agotado) {
        this.nombre = nombre;
        this.precio = precio;
        this.agotado = agotado;
    }

    public String getNombre() {
        return nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public Boolean getAgotado() {
        return agotado;
    }
}