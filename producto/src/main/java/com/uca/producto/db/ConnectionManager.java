package com.uca.producto.db;

import com.uca.producto.interfaces.IConnectionManager;
import oracle.jdbc.OracleConnection;
//prueba git
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//PRUEBA 1
public class ConnectionManager implements IConnectionManager, AutoCloseable {
    private Connection connection;

    public ConnectionManager() {
        this.connection = null;
    }

    @Override
    public boolean Connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FREE", "PROYECTO", "Dev$2024");
            return true;
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public void Disconnect() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T Execute(String command, ArrayList<TParametro<?>> parameters) {
        try {
            // Convertir la conexión.
            OracleConnection connection = (OracleConnection) this.connection;
            // Crear la sentencia que se ejecutará,
            CallableStatement statement = connection.prepareCall(String.format("{call %s}", command));
            // Definir el índice que tendrá la respuesta.
            Integer responseIndex = null;

            for (int i = 0; i < parameters.size(); i++) {
                TParametro<?> param = parameters.get(i);
                int index = i + 1;

                if (param.isRespuesta()) {
                    // Registrar parámetro de salida y almacenar su índice
                    statement.registerOutParameter(index, param.getTipoSQL());
                    responseIndex = index;
                } else {
                    // Configurar parámetro de entrada
                    if (param.getTipoSQL() == Types.ARRAY) {
                        // Verificar si el valor es un array.
                        if (param.getValor() instanceof ArrayList) {
                            // Crear la lista de estructuras para el array.
                            List<Struct> values = new ArrayList<>();
                            for (Object val : ((ArrayList<?>) param.getValor())) {
                                try {
                                    values.add(connection.createStruct(param.getNombreTipoEspecifico(), (Object[]) val));
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            // Asignar el valor del array.
                            statement.setArray(index, connection.createOracleArray(param.getNombreTipo(), values.toArray()));
                        }
                    } else {
                        statement.setObject(index, param.getValor(), param.getTipoSQL());
                    }
                }
            }

            // Ejecutar el procedimiento almacenado
            statement.executeUpdate();

            // Verificar si existe el índice del parámetro de respuesta
            if (responseIndex == null) {
                throw new SQLException("No se encontró un parámetro de salida en la lista de parámetros.");
            }

            // Obtener y retornar el parámetro de salida
            TParametro<?> responseParam = parameters.get(responseIndex - 1);
            responseParam.setValor(statement.getObject(responseIndex));
            return (T) responseParam.getValor();

        } catch (SQLException | ClassCastException e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, "Error al ejecutar el comando: " + command, e);
            return null;
        }
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }
}
