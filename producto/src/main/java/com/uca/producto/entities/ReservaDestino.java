package com.uca.producto.entities;

public class ReservaDestino {
    
    private int id_reserva_destino;
    private Alojamiento alojamiento;
    private Reserva reserva;
    

    public int getid_reserva_destino() {
        return id_reserva_destino;
    }
 
    public void setid_reserva_destino(int id_reserva_destino) {
        this.id_reserva_destino = id_reserva_destino;
    }


    public Alojamiento getalojamiento() {
        return alojamiento;
    }

    public void setalojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Reserva getreserva() {
        return reserva;
    }

    public void setreserva(Reserva reserva) {
        this.reserva = reserva;
    }

    

    public ReservaDestino() {
    }
 
    public ReservaDestino(int id_reserva_destino) {
        this.id_reserva_destino = id_reserva_destino;
    }

    public ReservaDestino(int id_reserva_destino, Alojamiento alojamiento, Reserva reserva ) {
        
        this.alojamiento = alojamiento;
        this.reserva = reserva;       
    }




}
