package com.uca.producto.entities;


public class Pais {
    private int idPais;
    private String nombre;
    private String codigoPais;

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Pais() {
    }

    public Pais(int idPais) {
        this.idPais = idPais;
    }

    public Pais(int idPais, String nombre, String codigoPais) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.codigoPais = codigoPais;

    }
   
}
