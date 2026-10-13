package org.example.ud_sesion9;

public class PedidoForm {
    private Integer unidades;
    private Double precio;
    private String cliente = "particular";
    private Boolean montaje = false;

    public Integer getUnidades() {
        return unidades;
    }
    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Boolean getMontaje() {
        return montaje;
    }
    public void setMontaje(Boolean montaje) {
        this.montaje = montaje;
    }
}
