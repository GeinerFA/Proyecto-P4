package com.uca.producto.entities;

import java.util.Date;

public class Reserva {
    private int id_reserva;
    private Date fecha_ida;
    private Date fecha_regreso;
    private int precio;
    private boolean estado; 
    private Cliente cliente;


    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFecha_ida() {
        return fecha_ida;
    }

    public void setFecha_ida(Date fecha_ida) {
        this.fecha_ida = fecha_ida;
    }

    public Date getFecha_regreso() {
        return fecha_regreso;
    }

    public void setFecha_regreso(Date fecha_regreso) {
        this.fecha_regreso = fecha_regreso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Reserva() {
    }
 
    public Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Reserva(int id_reserva, Date fecha_ida, Date fecha_regreso, int precio, boolean estado, Cliente cliente) {
        this.id_reserva = id_reserva;
        this.fecha_ida = fecha_ida;
        this.fecha_regreso = fecha_regreso;
        this.precio = precio;
        this.estado = estado;
        this.cliente = cliente;
    }
}
