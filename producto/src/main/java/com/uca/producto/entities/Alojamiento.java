package com.uca.producto.entities;
import java.util.Date;
 
public class Alojamiento {
    private int id_alojamiento;
    private String nombre;
    private int cantidad_personas;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private int precio;
    private String ubicacion;
    private boolean estado;
    private Destino destino;
 
    public int getidAlojamiento() {
        return id_alojamiento;
    }
 
    public void setidAlojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
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
 
    public Date getfecha_ingreso(){
        return fecha_ingreso;
    }
 
    public void setfecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
   
    public Date getfecha_salida(){
        return fecha_salida;
    }
 
    public void setfecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
 
    public int getprecio() {
        return precio;
    }
 
    public void setprecio(int precio) {
        this.precio = precio;
    }
 
    public String getubicacion() {
        return ubicacion;
    }
 
    public void setubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
 
    public boolean getestado() {
        return estado;
    }
 
    public void setestado(boolean estado) {
        this.estado = estado;
    }
    
    public Destino getdestino() {
        return destino;
    }

    public void setdestino(Destino destino) {
        this.destino = destino;
    }

    public Alojamiento() {
    }

    public Alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    public Alojamiento (int id_alojamiento, Destino destino){
        this.id_alojamiento = id_alojamiento;
        this.destino = destino;

    } 
    
    public Alojamiento (int id_alojamiento, String nombre, Destino destino){
        this.id_alojamiento = id_alojamiento;
        this.nombre = nombre;
        this.destino = destino;

    }
 
    public Alojamiento(int id_alojamiento, String nombre, int cantidadPersonas, Date fecha_ingreso, Date fecha_salida, int precio, String ubicacion,boolean estado, Destino destino) {
        this.id_alojamiento = id_alojamiento;
        this.nombre = nombre;
        this.cantidad_personas = cantidadPersonas;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.destino = destino;
        
    }

}