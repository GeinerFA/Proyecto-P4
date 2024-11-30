
package com.uca.producto.entities;

public class Destino {
    private int id_Destino;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private int id_Pais;

    public int getid_Destino() {
        return id_Destino;
    }

    public void setid_Destino(int id_Destino) {
        this.id_Destino = id_Destino;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public String setdescripcion(String descripcion) {
        return this.descripcion = descripcion;
    }

    public boolean getestado() {
        return estado;
    }

    public void setestado(boolean estado) {
        this.estado = estado;
    }

    public Destino() {
    }

    public Destino(int id_Destino) {
        this.id_Destino = id_Destino;
    }

    public int getid_Pais() {
        return id_Pais;
    }

    public void setidPais(int id_Pais) {
        this.id_Pais = id_Pais;
    }

    public Destino(int id_Destino, String nombre, String descripcion, boolean estado , int id_Pais) {
        this.id_Destino = id_Destino;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_Pais = id_Pais;
    }
}
