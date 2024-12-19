package com.uca.producto.logic;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Destino;
import com.uca.producto.entities.Pais;
import com.uca.producto.entities.Tour;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LTour {

    public ArrayList<Tour> Listar() {
        ArrayList<Tour> tours = new ArrayList<>();

        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_listar_tour(?)", parametros)) {
                    while (rs.next()) {
                        tours.add(new Tour(
                                rs.getInt("id_tour"),
                                rs.getString("nombre"),
                                rs.getInt("cantidad_Personas"),
                                rs.getDate("fecha_tour"),
                                rs.getInt("precio"),
                                rs.getString("descripcion"),
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

                                ))
                        );
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LTour.class.getName()).log(Level.SEVERE, null, ex);
                    return null;

                }
            }
            return tours;
        } catch (Exception ex) {
            Logger.getLogger(LTour.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Tour Consultar(int id_tour) {
        Tour tour = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_tour", id_tour, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_tour(?,?)", parametros)) {
                    if (rs.next()) {
                        // Cargamos la información del pais
                        tour = new Tour(
                                rs.getInt("id_tour"),
                                rs.getString("nombre"),
                                rs.getInt("cantidad_Personas"),
                                rs.getDate("fecha_tour"),
                                rs.getInt("precio"),
                                rs.getString("descripcion"),
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

                                ));
                    }
                }
            }
            return tour;
        } catch (Exception ex) {
            Logger.getLogger(LTour.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Guardar(Tour tour) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();

        parametros.add(new TParametro<>("p_nombre", tour.getNombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_cantidad_personas", tour.getCantidadPersonas(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_fecha_tour", tour.getFechaTour(), Types.DATE));
        parametros.add(new TParametro<>("p_precio", tour.getPrecio(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_descripcion", tour.getDescripcion(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", tour.isEstado(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_id_destino", tour.getDestino().getIdDestino(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_tour(?,?,?,?,?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public int Actualizar(Tour tour) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_tour", tour.getIdTour(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_nombre", tour.getNombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_cantidad_personas", tour.getCantidadPersonas(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_fecha_tour", tour.getFechaTour(), Types.DATE));
        parametros.add(new TParametro<>("p_precio", tour.getPrecio(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_descripcion", tour.getDescripcion(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", tour.isEstado(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_id_destino", tour.getDestino().getIdDestino(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_actualizar_tour(?,?,?,?,?,?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}
