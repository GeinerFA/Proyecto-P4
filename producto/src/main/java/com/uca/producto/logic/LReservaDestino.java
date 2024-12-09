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
import com.uca.producto.entities.Cliente;
import com.uca.producto.entities.Destino;
import com.uca.producto.entities.Pais;
import com.uca.producto.entities.Reserva;

public class LReservaDestino {

    public ReservaDestino Consultar(int id_reserva_destino) {
        ReservaDestino reservadestino = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_reserva_destino", id_reserva_destino, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_reserva_destino(?,?)", parametros)) {
                    if (rs.next()) {
                        reservadestino = new ReservaDestino(
                                rs.getInt("id_reserva_destino"),
                                new Alojamiento(
                                        rs.getInt("id_alojamiento"),
                                        rs.getString("nombre_alojamiento"),
                                        rs.getInt("cantidad_Personas"),
                                        rs.getDate("fecha_ingreso"),
                                        rs.getDate("fecha_salida"),
                                        rs.getInt("precio"),
                                        rs.getString("ubicacion"),
                                        rs.getBoolean("estado"),
                                        new Destino(
                                                rs.getInt("id_destino"),
                                                rs.getString("nombre_destino"),
                                                rs.getString("descripcion_destino"),
                                                rs.getBoolean("estado_destino"),
                                                new Pais(
                                                        rs.getInt("id_Pais"),
                                                        rs.getString("nombre_pais"),
                                                        rs.getString("codigo_Pais")))),
                                new Reserva(
                                        rs.getInt("id_reserva"),
                                        rs.getDate("fecha_ida"),
                                        rs.getDate("fecha_regreso"),
                                        rs.getInt("precio"),
                                        rs.getBoolean("estado"),
                                        new Cliente(rs.getInt("id_cliente"),
                                                rs.getString("nombre"),
                                                rs.getString("apellido"),
                                                rs.getString("pasaporte"),
                                                rs.getString("nacionalidad"),
                                                rs.getString("correo"),
                                                rs.getString("telefono"),
                                                rs.getBoolean("estado"))));
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
