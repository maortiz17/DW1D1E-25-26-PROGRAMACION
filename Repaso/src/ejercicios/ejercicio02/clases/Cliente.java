package ejercicios.ejercicio02.clases;

import java.util.HashMap;
import java.util.Map;

public class Cliente extends Usuario {
	// Clave: El objeto Producto. Valor: La cantidad solicitada.
    private Map<Producto, Integer> carrito;

    public Cliente(String nombre, String password) {
        super(nombre, password);
        this.carrito = new HashMap<>();
    }
    
    public void agregarProducto(Producto p, int cantidad) {
    	// Creamos copia defensiva del producto que añadiremos al mapa
    	Producto pCopia = new Producto(p); // Utilizamos el constructor de copia de la clase
        if (carrito.containsKey(pCopia)) {
            int cantidadActual = carrito.get(pCopia); // Si ya estaba actualizamos cantidad
            carrito.put(pCopia, cantidadActual + cantidad);
        } else {
            carrito.put(pCopia, cantidad);
        }
    }

    public Map<Producto, Integer> getCarrito() {
    	// Devolveremos copia defensiva del carrito
        // Creamos un mapa nuevo
        Map<Producto, Integer> copiaCarrito = new HashMap<>();
        
        // Iteramos sobre los elementos del mapa original
        for (Map.Entry<Producto, Integer> elemento : this.carrito.entrySet()) {
            
            Producto productoOriginal = elemento.getKey();
            Integer cantidad = elemento.getValue();
            
            // Copiamos la clave (el objeto Producto) usando el constructor de copia
            Producto copiaProducto = new Producto(productoOriginal);
            
            // Insertamos la copia y la cantidad en el nuevo mapa
            copiaCarrito.put(copiaProducto, cantidad);
        }
        
        // Devolvemos el mapa blindado
        return copiaCarrito;
    }

    public void vaciarCarrito() {
        carrito.clear();
    }
}
