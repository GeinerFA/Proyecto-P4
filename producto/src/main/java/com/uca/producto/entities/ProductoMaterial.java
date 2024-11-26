package com.uca.producto.entities;

public class ProductoMaterial {
    private int idProductoMaterial;
    private Material material;
    private int cantidad;

    public int getIdProductoMaterial() {
        return idProductoMaterial;
    }

    public void setIdProductoMaterial(int idProductoMaterial) {
        this.idProductoMaterial = idProductoMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoMaterial() {
    }

    public ProductoMaterial(int idProductoMaterial) {
        this.idProductoMaterial = idProductoMaterial;
    }

    public ProductoMaterial(int idProductoMaterial, Material material, int cantidad) {
        this.idProductoMaterial = idProductoMaterial;
        this.material = material;
        this.cantidad = cantidad;
    }
}
