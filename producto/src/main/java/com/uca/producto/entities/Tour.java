package com.uca.producto.entities;

import java.util.Date;

public class Tour {
    private int idTour;
    private String nombre;
    private int cantidadPersonas;
    private Date fechaTour;
    private int precio;
    private String descripcion;
    private boolean estado;
    private Destino destino;

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Date getFechaTour() {
        return fechaTour;
    }

    public void setFechaTour(Date fechaTour) {
        this.fechaTour = fechaTour;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Tour() {}

    public Tour(int idTour) {
        this.idTour = idTour;
    }

    public Tour(int idTour, String nombre, int cantidadPersonas, Date fechaTour, int precio, String descripcion,boolean estado, Destino destino) {
        this.destino = destino;
        this.idTour = idTour;
        this.nombre = nombre;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaTour = fechaTour;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }
}
