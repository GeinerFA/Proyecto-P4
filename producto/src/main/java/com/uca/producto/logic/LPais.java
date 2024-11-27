package com.uca.producto.logic;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Pais;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LPais {
    public ArrayList<Pais> Listar() {
        ArrayList<Pais> paises = new ArrayList<>();

        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_listar_pais(?)", parametros)) {
                    while (rs.next()) {
                        paises.add(new Pais(
                                rs.getInt("id_pais"),
                                rs.getString("nombre"),
                                rs.getString("codigo_pais")
                        ));
                    }
                }
                catch (Exception ex) {
                    Logger.getLogger(LPais.class.getName()).log(Level.SEVERE, null, ex);
                    return null;

                }
            }
            return paises;
        } catch (Exception ex) {
            Logger.getLogger(LPais.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Pais Consultar(int idPais) {
        Pais pais = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_pais", idPais, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_pais(?,?)", parametros)) {
                    if (rs.next()) {
                        // Cargamos la información del pais
                        pais = new Pais(
                            rs.getInt("id_pais"),
                            rs.getString("nombre"),
                            rs.getString("codigo_pais")
                        );

                    }
                }
            }
            return pais;
        } catch (Exception ex) {
            Logger.getLogger(LPais.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Guardar(Pais pais) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        
        parametros.add(new TParametro<>("p_nombre", pais.getNombre(), Types.VARCHAR));
        //Cambio codigoPais
        parametros.add(new TParametro<>("p_codigo_pais", pais.getCodigoPais(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_pais(?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public int Actualizar(Pais pais) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_pais", pais.getIdPais(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_nombre", pais.getNombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_codigo_pais", pais.getCodigoPais(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_actualizar_pais(?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}
