package ejercicios.ejercicio01.clases;

import java.io.Serializable;

public class Producto implements Serializable{
    private int codigo;
    private String descripcion;
    private int stock;
    private double precio;
    
    public Producto(int codigo, String descripcion, int stock, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
    
    @Override
    public String toString(){
        return String.format("%d - %s. Stock: %d. Precio: %.2f", codigo, descripcion, stock, precio);
    }
}
