package com.uca.producto.logic;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Tour;
import com.uca.producto.entities.Destino;
import com.uca.producto.entities.Pais;

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
                                    rs.getString("nombre"),
                                    rs.getString("descripcion"),
                                    rs.getBoolean("estado"),
                                new Pais(
                                        rs.getInt("id_Pais"),
                                        rs.getString("nombre"),
                                        rs.getString("codigo_Pais"))
                               
                                )
                            )
                        );
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LAlojamiento.class.getName()).log(Level.SEVERE, null, ex);
                    return null;

                }
            }
            return tours;
        } catch (Exception ex) {
            Logger.getLogger(LAlojamiento.class.getName()).log(Level.SEVERE, null, ex);
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
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getBoolean("estado"),
                            new Pais(
                                    rs.getInt("id_Pais"),
                                    rs.getString("nombre"),
                                    rs.getString("codigo_Pais"))
                           
                            )
                        );

                    }
                }
            }
            return tour;
        } catch (Exception ex) {
            Logger.getLogger(LAlojamiento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Guardar(Tour tour) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();

        parametros.add(new TParametro<>("p_nombre", tour.getnombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_cantidad_personas", tour.getcantidadPersonas(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_fecha_ingreso", tour.getfecha_ingreso(), Types.DATE));
        parametros.add(new TParametro<>("p_precio", tour.getprecio(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_ubicacion", tour.getubicacion(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", tour.getestado(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_id_destino", tour.getdestino().getid_Destino(), Types.NUMERIC));
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
        parametros.add(new TParametro<>("p_id_tour", tour.getidAlojamiento(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_nombre", tour.getnombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_cantidad_personas", tour.getcantidadPersonas(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_fecha_ingreso", tour.getfecha_ingreso(), Types.DATE));
        parametros.add(new TParametro<>("p_precio", tour.getprecio(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_ubicacion", tour.getubicacion(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", tour.getestado(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_id_destino", tour.getdestino().getid_Destino(), Types.NUMERIC));
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
