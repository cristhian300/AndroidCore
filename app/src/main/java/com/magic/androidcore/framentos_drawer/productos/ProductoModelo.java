package com.magic.androidcore.framentos_drawer.productos;

public class ProductoModelo {


    private String NombreProducto;
    private int fotoProducto;

    public ProductoModelo(String nombreProducto, int fotoProducto) {
        NombreProducto = nombreProducto;
        this.fotoProducto = fotoProducto;
    }

    public ProductoModelo() {
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public int getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(int fotoProducto) {
        this.fotoProducto = fotoProducto;
    }
}
