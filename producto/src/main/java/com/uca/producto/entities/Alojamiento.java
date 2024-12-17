package com.uca.producto.entities;

import java.util.Date;

public class Alojamiento {
    private int idAlojamiento;
    private String nombre;
    private int cantidadPersonas;
    private Date fechaIngreso;
    private Date fechaSalida;
    private int precio;
    private String ubicacion;
    private boolean estado;
    private Destino destino;

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Alojamiento() {}

    public Alojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public Alojamiento(int idAlojamiento, Destino destino) {
        this.idAlojamiento = idAlojamiento;
        this.destino = destino;
    }

    public Alojamiento(int idAlojamiento, String nombre, Destino destino) {
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.destino = destino;
    }

    public Alojamiento(int idAlojamiento, String nombre, int cantidadPersonas, Date fechaIngreso, Date fechaSalida, int precio, String ubicacion, boolean estado, Destino destino) {
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.destino = destino;
    }
}