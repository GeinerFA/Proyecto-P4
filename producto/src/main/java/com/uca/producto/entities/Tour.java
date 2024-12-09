package com.uca.producto.entities;

import java.util.Date;

public class Tour {
    
private int id_tour;
    private String nombre;
    private int cantidad_personas;
    private Date fecha_tour;
    private int precio;
    private String descripcion;
    private boolean estado;
    private Destino destino;
 
    public int getidTour() {
        return id_tour;
    }
 
    public void setidTour(int id_tour) {
        this.id_tour = id_tour;
    }
 
    public String getnombre() {
        return nombre;
    }
 
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getcantidadPersonas(){
        return cantidad_personas;
    }
   
    public void setcantidadPersonas(int cantidadPersonas) {
        this.cantidad_personas = cantidadPersonas;
    }
 
    public Date getfecha_tour(){
        return fecha_tour;
    }
 
    public void setfecha_tour(Date fecha_tour) {
        this.fecha_tour = fecha_tour;
    }
 
    public int getprecio() {
        return precio;
    }
 
    public void setprecio(int precio) {
        this.precio = precio;
    }
 
    public String getdescripcion() {
        return descripcion;
    }
 
    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
    public boolean getestado() {
        return estado;
    }
 
    public void setestado(boolean estado) {
        this.estado = estado;
    }
 
    public Tour() {
    }
 
    public Tour(int id_tour) {
        this.id_tour = id_tour;
    }
 
    public Destino getdestino() {
        return destino;
    }

    public void setdestino(Destino destino) {
        this.destino = destino;
    }
 
   
 
    public Tour(int id_tour, String nombre, int cantidadPersonas, Date fecha_tour, int precio, String descripcion,boolean estado, Destino destino) {
        this.id_tour = id_tour;
        this.nombre = nombre;
        this.cantidad_personas = cantidadPersonas;
        this.fecha_tour = fecha_tour;
        this.precio = precio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.destino = destino;
        
    }

}
