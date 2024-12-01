package com.uca.producto.logic;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Destino;
import com.uca.producto.entities.Pais;

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
                                rs.getInt("id_destino"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getBoolean("estado"),
                                new Pais (rs.getInt("idPais"))
                                
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

    public Destino Consultar(int id_Destino) {
        Destino destino = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_destino", id_Destino, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_destino(?,?)", parametros)) {
                    if (rs.next()) {
                        // Cargamos la información del destino
                        destino = new Destino(
                                rs.getInt("id_Destino"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getBoolean("estado"),
                                new Pais (rs.getInt("id_pais"))
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
        
        parametros.add(new TParametro<>("p_nombre", destino.getnombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_descripcion", destino.getdescripcion(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", destino.getestado()? 1 : 0, Types.INTEGER));
//        parametros.add(new TParametro<>("p_id_Pais", destino.getid_Pais(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_destino(?,?,?,?,?)", parametros);
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
        parametros.add(new TParametro<>("p_id_destino", destino.getid_Destino(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_nombre", destino.getnombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_descripcion", destino.getdescripcion(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", destino.getestado()? 1 : 0, Types.INTEGER));
  //      parametros.add(new TParametro<>("p_id_Pais", destino.getid_Pais(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_actualizar_destino(?,?,?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}
