package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio18;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<LineaCompra> carrito;

    public Cliente() {
        this.carrito = new ArrayList<>();
    }

    public void agregarLinea(Producto p, int cant) {
        this.carrito.add(new LineaCompra(p, cant));
    }

    public List<LineaCompra> getCarrito() {
        return new ArrayList(carrito);
    }
}