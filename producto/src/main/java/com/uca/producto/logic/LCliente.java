package com.uca.producto.logic;

import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Cliente;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LCliente {
    public ArrayList<Cliente> Listar() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_listar_cliente(?)", parametros)) {
                    while (rs.next()) {
                        clientes.add(new Cliente(
                                rs.getInt("id_cliente"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("pasaporte"),
                                rs.getString("nacionalidad"),
                                rs.getString("correo"),
                                rs.getString("telefono"),
                                rs.getBoolean("estado")));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LCliente.class.getName()).log(Level.SEVERE, null, ex);
                    return null;

                }
            }
            return clientes;
        } catch (Exception ex) {
            Logger.getLogger(LCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Cliente Consultar(int idCliente) {
        Cliente Cliente = null;

        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_cliente", idCliente, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_cliente(?,?)", parametros)) {
                    if (rs.next()) {
                        // Cargamos la información del Cliente
                        Cliente = new Cliente(
                                rs.getInt("id_cliente"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("pasaporte"),
                                rs.getString("nacionalidad"),
                                rs.getString("correo"),
                                rs.getString("telefono"),
                                rs.getBoolean("estado"));

                    }
                }
            }
            return Cliente;
        } catch (Exception ex) {
            Logger.getLogger(LCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Guardar(Cliente Cliente) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();

        parametros.add(new TParametro<>("p_nombre", Cliente.getNombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_apellido", Cliente.getApellido(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_pasaporte", Cliente.getPasaporte(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_nacionalidad", Cliente.getNacionalidad(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_correo", Cliente.getCorreo(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_telefono", Cliente.getTelefono(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", Cliente.getEstado(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_cliente(?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public int Actualizar(Cliente Cliente) {
        // Definir y cargar los parámetros.
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_Cliente", Cliente.getIdCliente(), Types.NUMERIC));
        parametros.add(new TParametro<>("p_nombre", Cliente.getNombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_apellido", Cliente.getApellido(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_pasaporte", Cliente.getPasaporte(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_nacionalidad", Cliente.getNacionalidad(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_correo", Cliente.getCorreo(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_telefono", Cliente.getTelefono(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_estado", Cliente.getEstado(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));

        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_actualizar_cliente(?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}
