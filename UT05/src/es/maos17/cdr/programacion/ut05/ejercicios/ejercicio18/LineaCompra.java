package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio18;

public class LineaCompra {
	private Producto producto;
    private int cantidad;

    public LineaCompra(Producto producto, int cantidad) {
        this.producto = new Producto(producto);
        this.cantidad = cantidad;
    }

    public Producto getProducto() { 
    	return new Producto(producto); 
    }
    public int getCantidad() { 
    	return cantidad; 
    }
    
    public double calcularSubtotal() {
        return producto.getPrecioUnitario() * cantidad;
    }
}