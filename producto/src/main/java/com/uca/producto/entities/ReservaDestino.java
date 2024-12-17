package com.uca.producto.entities;

public class ReservaDestino {
    
    private int idReservaDestino;
    private Alojamiento alojamiento;
    private Destino destino;
    

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

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public ReservaDestino() {
    }
 
    public ReservaDestino(int idReservaDestino) {
        this.idReservaDestino = idReservaDestino;
    }

    public ReservaDestino(int idReservaDestino, Alojamiento alojamiento) {        
        this.alojamiento = alojamiento;
    }

}
