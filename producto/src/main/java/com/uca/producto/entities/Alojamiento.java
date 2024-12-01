package com.uca.producto.entities;
import java.util.Date;
 
public class Alojamiento {
    private int idAlojamiento;
    private String nombre;
    private int cantidadPersonas;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private int precio;
    private String ubicacion;
    private boolean estado;
    private int idDestino;
    private int idPais;
 
    public int getidAlojamiento() {
        return idAlojamiento;
    }
 
    public void setidAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }
 
    public String getnombre() {
        return nombre;
    }
 
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getcantidadPersonas(){
        return cantidadPersonas;
    }
   
    public void setcantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
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
 
    public Alojamiento() {
    }
 
    public Alojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }
 
    public int getidDestino() {
        return idDestino;
    }
 
    public void setidDestino(int idDestino) {
        this.idDestino = idDestino;
    }
 
    public int getidPais() {
        return idPais;
    }
 
    public void setidPais(int idPais) {
        this.idPais = idPais;
    }
 
    public Alojamiento(int idAlojamiento, String nombre, int cantidadPersonas, Date fecha_ingreso, Date fecha_salida, int precio, String ubicacion,boolean estado, int idDestino, int idPais) {
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.cantidadPersonas = cantidadPersonas;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.idDestino = idDestino;
        this.idPais = idPais;
    }
}