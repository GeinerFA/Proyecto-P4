package com.uca.producto.logic;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.ReservaDestino;
import com.uca.producto.entities.Alojamiento;
import com.uca.producto.entities.Destino;

public class LReservaDestino {

    public ReservaDestino Listar(int idReserva) {
        ReservaDestino reservadestino = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_reserva_destino", idReserva, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_reserva_destino(?,?)", parametros)) {
                    if (rs.next()) {
                        reservadestino = new ReservaDestino(
                                rs.getInt("id_reserva_destino"),
                                new Alojamiento(
                                        rs.getString("nombre_alojamiento"),
                                        new Destino(
                                                rs.getString("nombre_destino"))));
                                
                    }
                }
            }
            return reservadestino;
        } catch (Exception ex) {
            Logger.getLogger(LReservaDestino.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
