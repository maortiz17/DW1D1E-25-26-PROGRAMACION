package ejercicios.ejercicio03.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ejercicios.ejercicio03.clases.Producto;

public interface ProductoDAO {
	boolean insertar(Producto p) throws SQLException;
	List<Producto> buscarProductos(String texto) throws SQLException;
    Producto buscarProducto(int codigo) throws SQLException;
	boolean actualizarStock(int codigo, int nuevoStock) throws SQLException;
    List<Producto> obtenerTodos() throws SQLException;
    double procesarCompra(Map<Producto, Integer> carrito) throws SQLException;
}
