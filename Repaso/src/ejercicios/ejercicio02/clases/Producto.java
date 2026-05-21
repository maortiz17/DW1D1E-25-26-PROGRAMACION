package ejercicios.ejercicio02.clases;

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
    
    //Constructor de copia
    public Producto(Producto p) {
        this.codigo = p.getCodigo();
        this.descripcion = p.getDescripcion(); 
        this.stock = p.getStock();
        this.precio = p.getPrecio();
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
    
    // Implementamos equals y hasCode, porque objetos de esta clase serán claves de un Map
    // Dos productos son iguales si tienen el mismo código

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Producto producto = (Producto) o;
        return codigo == producto.codigo;
    }

    @Override
    public int hashCode() {
        // Generamos el hash por el código, por coherencia con equals
        return Integer.hashCode(codigo);
    }
    
    @Override
    public String toString(){
        return String.format("%d - %s. Stock: %d. Precio: %.2f", codigo, descripcion, stock, precio);
    }
}
