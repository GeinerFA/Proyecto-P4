package com.uca.producto.entities;

import java.util.Date;

public class Reserva {
    private int id_reserva;
    private Date fecha_ida;
    private Date fecha_regreso;
    private double precio;
    private char estado; // Representa '0' o '1'
    private Cliente cliente; // Relación con la entidad Cliente

    // Constructor vacío
    public Reserva() {
    }

    // Constructor con id
    public Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    // Constructor con todos los campos
    public Reserva(int id_reserva, Date fecha_ida, Date fecha_regreso, double precio, char estado, Cliente cliente) {
        this.id_reserva = id_reserva;
        this.fecha_ida = fecha_ida;
        this.fecha_regreso = fecha_regreso;
        this.precio = precio;
        this.estado = estado;
        this.cliente = cliente;
    }

    // Getters y setters
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        if (estado == '0' || estado == '1') {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado debe ser '0' o '1'.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
