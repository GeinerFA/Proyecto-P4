package com.uca.producto.logic;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Destino;

public class LDestino {
    public ArrayList<Destino> Listar() {
        ArrayList<Destino> destinos = new ArrayList<>();
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_listar_destino(?)", parametros)) {
                    while (rs.next()) {
                        destinos.add(new Destino(
                                rs.getInt("idDestino"),
                                rs.getString("nombre"),
                                rs.getClob("descripcion"),
                                rs.getBoolean("estado"),
                                rs.getInt("idPais")
                        ));
                    }
                }
                catch (Exception ex) {
                    Logger.getLogger(LDestino.class.getName()).log(Level.SEVERE, null, ex);
                    return null;

                }
            }
            return destinos;
        } catch (Exception ex) {
            Logger.getLogger(LDestino.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Destino Consultar(int idDestino) {
        Destino destino = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_destino", idDestino, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_destino(?,?)", parametros)) {
                    if (rs.next()) {
                        // Cargamos la información del destino
                        destino = new Destino(
                                rs.getInt("idDestino"),
                                rs.getString("nombre"),
                                rs.getClob("descripcion"),
                                rs.getBoolean("estado"),
                                rs.getInt("idPais")
                        );

                    }
                }
            }
            return destino;
        } catch (Exception ex) {
            Logger.getLogger(LDestino.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Guardar(Destino destino) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        
        parametros.add(new TParametro<>("nombre", destino.getnombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("descripcion", destino.getidDestino(), Types.VARCHAR));
        parametros.add(new TParametro<>("estado", destino.getestado(), Types.VARCHAR));
        parametros.add(new TParametro<>("idPais", destino.getidDestino(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_destino(?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public int Actualizar(Destino destino) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("nombre", destino.getnombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("descripcion", destino.getidDestino(), Types.VARCHAR));
        parametros.add(new TParametro<>("estado", destino.getestado(), Types.VARCHAR));
        parametros.add(new TParametro<>("idPais", destino.getidDestino(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_actualizar_destino(?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}
