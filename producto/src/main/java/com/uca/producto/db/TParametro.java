package com.uca.producto.db;

public class TParametro<T> {
    private String nombre;
    private String nombreTipo;
    private String nombreTipoEspecifico;
    private Object valor;
    private int tipoSQL;
    private boolean respuesta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getNombreTipoEspecifico() {
        return nombreTipoEspecifico;
    }

    public void setNombreTipoEspecifico(String nombreTipoEspecifico) {
        this.nombreTipoEspecifico = nombreTipoEspecifico;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getTipoSQL() {
        return tipoSQL;
    }

    public void setTipoSQL(int tipoSQL) {
        this.tipoSQL = tipoSQL;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public TParametro(String nombre, T valor, int tipoSQL) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipoSQL = tipoSQL;
    }

    public TParametro(String nombre, String nombreTipo, String nombreTipoEspecifico, T valor, int tipoSQL) {
        this.nombre = nombre;
        this.nombreTipo = nombreTipo;
        this.nombreTipoEspecifico = nombreTipoEspecifico;
        this.valor = valor;
        this.tipoSQL = tipoSQL;
    }

    public TParametro(String nombre, String nombreTipo, T valor, int tipoSQL) {
        this.nombre = nombre;
        this.nombreTipo = nombreTipo;
        this.valor = valor;
        this.tipoSQL = tipoSQL;
    }

    public TParametro(String nombre, T valor, int tipoSQL, boolean respuesta) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipoSQL = tipoSQL;
        this.respuesta = respuesta;
    }
}
