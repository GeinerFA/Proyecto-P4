package com.uca.producto.entities;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {
    private int idReserva;
    private Date fechaIda;
    private Date fechaRegreso;
    private int precio;
    private boolean estado;
    private Cliente cliente;
    private ArrayList<ReservaDestino> lineas;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(Date fechaIda) {
        this.fechaIda = fechaIda;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ReservaDestino> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<ReservaDestino> lineas) {
        this.lineas = lineas;
    }

    public Reserva() { }

    public Reserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(int idReserva, Date fechaIda, Date fechaRegreso, int precio, boolean estado, Cliente cliente) {
        this.idReserva = idReserva;
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;
        this.precio = precio;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Reserva(int idReserva, Date fechaIda, Date fechaRegreso, int precio, boolean estado, Cliente cliente, ArrayList<ReservaDestino> lineas) {
        this.idReserva = idReserva;
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;
        this.precio = precio;
        this.estado = estado;
        this.cliente = cliente;
        this.lineas = lineas;
    }
}