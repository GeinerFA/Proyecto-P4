package com.uca.producto.entities;

public class Material {
    private int idMaterial;
    private String nombre;
    private int cantidad;

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Material(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Material(int idMaterial, String nombre, int cantidad) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
}

