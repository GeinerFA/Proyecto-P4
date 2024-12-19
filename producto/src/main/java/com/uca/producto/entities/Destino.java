package com.uca.producto.entities;

public class Destino {
    private int idDestino;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Pais pais;

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Destino() {}

    public Destino(int idDestino) {
        this.idDestino = idDestino;
    }

    public Destino(String nombre) {
        this.nombre = nombre;
    }

    public Destino(int idDestino, String nombre, String descripcion, boolean estado, Pais pais) {
        this.idDestino = idDestino;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.pais = pais;
    }
}
