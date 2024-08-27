package com.example.pizzeria.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer idItem;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Double cantidad;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenPizza orden;


    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public OrdenPizza getOrden() {
        return orden;
    }

    public void setOrden(OrdenPizza orden) {
        this.orden = orden;
    }

    
}
