
package com.uca.producto.entities;
import java.sql.Clob;

public class Destino {
    private int idDestino;
    private String nombre;
    private Clob descripcion;
    private boolean estado;
    private int idPais;

    public int getidDestino() {
        return idDestino;
    }

    public void setidAlojamiento(int idAlojamiento) {
        this.idDestino = idAlojamiento;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public Clob getdescripcion() {
        return descripcion;
    }

    public Clob setdescripcion(Clob descripcion) {
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

    public Destino(int idAlojamiento) {
        this.idDestino = idAlojamiento;
    }

    public int getidPais() {
        return idPais;
    }

    public void setidPais(int idPais) {
        this.idPais = idPais;
    }

    public Destino(int idDestino, String nombre, Clob descripcion, boolean estado , int idPais) {
        this.idDestino = idDestino;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idPais = idPais;
    }
}
