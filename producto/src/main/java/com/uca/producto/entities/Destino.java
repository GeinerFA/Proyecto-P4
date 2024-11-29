
package com.uca.producto.entities;
import java.sql.Clob;

public class Destino {
    private int id_Destino;
    private String nombre;
    private Clob descripcion;
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

    public Destino(int id_Destino) {
        this.id_Destino = id_Destino;
    }

    public int getid_Pais() {
        return id_Pais;
    }

    public void setidPais(int idPais) {
        this.id_Pais = idPais;
    }

    public Destino(int id_Destino, String nombre, Clob descripcion, boolean estado , int idPais) {
        this.id_Destino = id_Destino;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_Pais = idPais;
    }
}
