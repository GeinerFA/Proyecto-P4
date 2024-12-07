package com.uca.producto.logic;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Reserva;

public class LReserva {
    
    public ArrayList<Reserva> Listar() {
        ArrayList<Reserva> reservas = new ArrayList<>();

        // Parámetros
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_listar_reserva(?)", parametros)) {
                    while (rs.next()) {
                        reservas.add(new Reserva(
                                rs.getInt("id_reserva"),
                                rs.getDate("fecha_ida"),
                                rs.getDate("fecha_regreso"),
                                rs.getDouble("precio"),
                                rs.getString("estado").charAt(0),
                                rs.getInt("id_cliente")
                        ));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LReserva.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
            return reservas;
        } catch (Exception ex) {
            Logger.getLogger(LReserva.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Reserva Consultar(int idReserva) {
        Reserva reserva = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_reserva", idReserva, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_reserva(?,?)", parametros)) {
                    if (rs.next()) {
                        reserva = new Reserva(
                                rs.getInt("id_reserva"),
                                rs.getDate("fecha_ida"),
                                rs.getDate("fecha_regreso"),
                                rs.getDouble("precio"),
                                rs.getString("estado").charAt(0),
                                rs.getInt("id_cliente")
                        );
                    }
                }
            }
            return reserva;
        } catch (Exception ex) {
            Logger.getLogger(LReserva.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Guardar(Reserva reserva) {
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_fecha_ida", reserva.getFechaIda(), Types.DATE));
        parametros.add(new TParametro<>("p_fecha_regreso", reserva.getFechaRegreso(), Types.DATE));
        parametros.add(new TParametro<>("p_precio", reserva.getPrecio(), Types.DOUBLE));
        parametros.add(new TParametro<>("p_estado", String.valueOf(reserva.getEstado()), Types.CHAR));
        parametros.add(new TParametro<>("p_id_cliente", reserva.getIdCliente(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_reserva(?,?,?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(LReserva.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public int Actualizar(Reserva reserva) {
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_reserva", reserva.getIdReserva(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_fecha_ida", reserva.getFechaIda(), Types.DATE));
        parametros.add(new TParametro<>("p_fecha_regreso", reserva.getFechaRegreso(), Types.DATE));
        parametros.add(new TParametro<>("p_precio", reserva.getPrecio(), Types.DOUBLE));
        parametros.add(new TParametro<>("p_estado", String.valueOf(reserva.getEstado()), Types.CHAR));
        parametros.add(new TParametro<>("p_id_cliente", reserva.getIdCliente(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_actualizar_reserva(?,?,?,?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(LReserva.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}
