package com.uca.producto.interfaces;

import com.uca.producto.db.TParametro;

import java.util.ArrayList;

public interface IConnectionManager {
    boolean Connect();
    void Disconnect();
    <T> T Execute(String command, ArrayList<TParametro<?>> parameters);
}
