package com.uca.producto.logic;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Material;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LMaterial {
    public ArrayList<Material> Listar() {
        ArrayList<Material> materiales = new ArrayList<>();

        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("dev.operaciones.sp_op_listar_material(?)", parametros)) {
                    while (rs.next()) {
                        materiales.add(new Material(
                                rs.getInt("id_material"),
                                rs.getString("nombre"),
                                rs.getInt("cantidad")
                        ));
                    }
                }
            }
            return materiales;
        } catch (Exception ex) {
            Logger.getLogger(LMaterial.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Guardar(Material material) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_nombre", material.getNombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_cantidad", material.getCantidad(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_material(?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}
