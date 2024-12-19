package com.uca.producto.entities;

public class ReservaDestino {
    private int idReservaDestino;
    private Alojamiento alojamiento;
    private Tour tour;

    public int getIdReservaDestino() {
        return idReservaDestino;
    }

    public void setIdReservaDestino(int idReservaDestino) {
        this.idReservaDestino = idReservaDestino;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public ReservaDestino() {
    }

    public ReservaDestino(int idReservaDestino) {
        this.idReservaDestino = idReservaDestino;
    }

    public ReservaDestino(int idReservaDestino, Alojamiento alojamiento) {
        this.idReservaDestino = idReservaDestino;
        this.alojamiento = alojamiento;
    }

    public ReservaDestino(int idReservaDestino, Alojamiento alojamiento, Tour tour) {
        this.idReservaDestino = idReservaDestino;
        this.alojamiento = alojamiento;
        this.tour = tour;
    }
}