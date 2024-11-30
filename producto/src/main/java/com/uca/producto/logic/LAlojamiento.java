package com.uca.producto.logic;
 
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import com.uca.producto.db.ConnectionManager;
import com.uca.producto.db.TParametro;
import com.uca.producto.entities.Alojamiento;
 
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
                                rs.getInt("idAlojamiento"),
                                rs.getString("nombre"),
                                rs.getInt("cantidadPersonas"),
                                rs.getDate("fecha_ingreso"),
                                rs.getDate("fecha_salida"),
                                rs.getInt("precio"),
                                rs.getString("ubicacion"),
                                rs.getBoolean("estado"),
                                rs.getInt("idDestino"),
                                rs.getInt("idAlojamiento")
                        ));
                    }
                }
                catch (Exception ex) {
                    Logger.getLogger(LAlojamiento.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
 
                }
            }
            return alojamientos;
        } catch (Exception ex) {
            Logger.getLogger(LAlojamiento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
 
    public Alojamiento Consultar(int idAlojamiento) {
        Alojamiento alojamiento = null;
 
        ArrayList<TParametro<?>> parametros = new ArrayList<>();
        parametros.add(new TParametro<>("p_id_alojamiento", idAlojamiento, Types.NUMERIC));
        parametros.add(new TParametro<>("p_respuesta", null, Types.REF_CURSOR, true));
 
        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                try (ResultSet rs = cm.Execute("proyecto.operaciones.sp_op_consultar_alojamiento(?,?)", parametros)) {
                    if (rs.next()) {
                        // Cargamos la información del pais
                        alojamiento = new Alojamiento(
                            rs.getInt("idAlojamiento"),
                                rs.getString("nombre"),
                                rs.getInt("cantidadPersonas"),
                                rs.getDate("fecha_ingreso"),
                                rs.getDate("fecha_salida"),
                                rs.getInt("precio"),
                                rs.getString("ubicacion"),
                                rs.getBoolean("estado"),
                                rs.getInt("idDestino"),
                                rs.getInt("idAlojamiento")
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
       
        parametros.add(new TParametro<>("p_nombre", alojamiento.getnombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("cantidadPersonas", alojamiento.getcantidadPersonas(), Types.VARCHAR));
        parametros.add(new TParametro<>("fecha_ingreso", alojamiento.getfecha_ingreso(), Types.VARCHAR));
        parametros.add(new TParametro<>("fecha_salida", alojamiento.getfecha_salida(), Types.VARCHAR));
        parametros.add(new TParametro<>("precio", alojamiento.getprecio(), Types.VARCHAR));
        parametros.add(new TParametro<>("ubicacion", alojamiento.getubicacion(), Types.VARCHAR));
        parametros.add(new TParametro<>("estado", alojamiento.getestado(), Types.VARCHAR));
        parametros.add(new TParametro<>("idDestino", alojamiento.getidDestino(), Types.VARCHAR));
        parametros.add(new TParametro<>("idPais", alojamiento.getidPais(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));
 
        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_guardar_alojamiento(?,?,?)", parametros);
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
        parametros.add(new TParametro<>("p_nombre", alojamiento.getnombre(), Types.VARCHAR));
        parametros.add(new TParametro<>("cantidadPersonas", alojamiento.getcantidadPersonas(), Types.VARCHAR));
        parametros.add(new TParametro<>("fecha_ingreso", alojamiento.getfecha_ingreso(), Types.VARCHAR));
        parametros.add(new TParametro<>("fecha_salida", alojamiento.getfecha_salida(), Types.VARCHAR));
        parametros.add(new TParametro<>("precio", alojamiento.getprecio(), Types.VARCHAR));
        parametros.add(new TParametro<>("ubicacion", alojamiento.getubicacion(), Types.VARCHAR));
        parametros.add(new TParametro<>("estado", alojamiento.getestado(), Types.VARCHAR));
        parametros.add(new TParametro<>("idDestino", alojamiento.getidDestino(), Types.VARCHAR));
        parametros.add(new TParametro<>("idPais", alojamiento.getidPais(), Types.VARCHAR));
        parametros.add(new TParametro<>("p_respuesta", null, Types.INTEGER, true));
 
        try (ConnectionManager cm = new ConnectionManager()) {
            if (cm.Connect()) {
                return cm.Execute("proyecto.operaciones.sp_op_actualizar_alojamiento(?,?,?,?)", parametros);
            }
            return 0;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}