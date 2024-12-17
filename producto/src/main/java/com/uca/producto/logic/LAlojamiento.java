package com.uca.producto.logic;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Alojamiento;
import com.uca.producto.entities.Destino;
import com.uca.producto.entities.Pais;

public class LAlojamiento {
    public ArrayList<Alojamiento> Listar() {
        ArrayList<Alojamiento> alojamientos = new ArrayList<>();

        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_listar_alojamiento(?)", parametros)) {
                    while (rs.next()) {
                        alojamientos.add(new Alojamiento(
                                rs.getInt("id_alojamiento"),
                                rs.getString("nombre"),
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
                                        rs.getString("codigo_Pais"))
                               
                                )
                            )
                        );
                    }
                }
            }
            return alojamientos;
        } catch (Exception ex) {
            Logger.getLogger(LAlojamiento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Alojamiento Consultar(int id_alojamiento) {
        Alojamiento alojamiento = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_alojamiento", id_alojamiento, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_alojamiento(?,?)", parametros)) {
                    if (rs.next()) {
                        // Cargamos la información del pais
                        alojamiento = new Alojamiento(
                            rs.getInt("id_Alojamiento"),
                            rs.getString("nombre"),
                            rs.getInt("cantidad_personas"),
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
                                            rs.getString("nombre_Pais"),
                                            rs.getString("codigo_Pais")
                                    )
                            )
                        );
                    }
                }
            }
            return alojamiento;
        } catch (Exception ex) {
            Logger.getLogger(LAlojamiento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Guardar(Alojamiento alojamiento) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();

        parametros.add(new TParametro<>("p_nombre", alojamiento.getNombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_cantidad_personas", alojamiento.getCantidadPersonas(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_fecha_ingreso", alojamiento.getFechaIngreso(), Types.DATE));
        parametros.add(new TParametro<>("p_fecha_salida", alojamiento.getFechaSalida(), Types.DATE));
        parametros.add(new TParametro<>("p_precio", alojamiento.getPrecio(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_ubicacion", alojamiento.getUbicacion(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", alojamiento.isEstado(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_id_destino", alojamiento.getDestino().getIdDestino(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_alojamiento(?,?,?,?,?,?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public int Actualizar(Alojamiento alojamiento) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_alojamiento", alojamiento.getIdAlojamiento(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_nombre", alojamiento.getNombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_cantidad_personas", alojamiento.getCantidadPersonas(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_fecha_ingreso", alojamiento.getFechaIngreso(), Types.DATE));
        parametros.add(new TParametro<>("p_fecha_salida", alojamiento.getFechaSalida(), Types.DATE));
        parametros.add(new TParametro<>("p_precio", alojamiento.getPrecio(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_ubicacion", alojamiento.getUbicacion(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", alojamiento.isEstado(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_id_destino", alojamiento.getDestino().getIdDestino(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_actualizar_alojamiento(?,?,?,?,?,?,?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}