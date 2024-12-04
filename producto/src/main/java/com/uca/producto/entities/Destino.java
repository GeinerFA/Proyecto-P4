
package com.uca.producto.entities;

public class Destino {
    private int id_destino;
    private int id_pais;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Pais pais;

    public int getid_Destino() {
        return id_destino;
    }

    public void setid_Destino(int id_destino) {
        this.id_destino = id_destino;
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

    public Destino(int id_destino) {
        this.id_destino = id_destino;
    }

    public Pais getpais() {
        return pais;
    }
    public int getidpais() {
        return this.id_pais;
    }

    public void setpais(Pais pais) {
        this.pais = pais;
    }

    public Destino(int id_destino, String nombre, String descripcion, boolean estado , Pais pais) {
        this.id_destino = id_destino;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.pais = pais;
    }
}
