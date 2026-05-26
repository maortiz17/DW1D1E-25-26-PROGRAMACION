package ejercicios.ejercicio03.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ejercicios.ejercicio03.clases.Producto;
import ejercicios.ejercicio03.dao.ProductoDAO;

public class ProductoDAOImpl implements ProductoDAO {

	// Ajustar estos parámetros según el esquema Oracle utilizado
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
	private static final String USER = "repasojava";
	private static final String PASS = "oracle123";

	// Consultas SQL
	private static final String SQL_INSERT = "INSERT INTO productos (codigo, descripcion, stock, precio) VALUES (?, ?, ?, ?)";
	private static final String SQL_SELECT_PRODUCTOS = "SELECT codigo, descripcion, stock, precio FROM productos WHERE codigo = ? OR descripcion LIKE ?";
	private static final String SQL_SELECT_PRODUCTO = "SELECT codigo, descripcion, stock, precio FROM productos WHERE codigo = ?";
	private static final String SQL_SELECT_TODO = "SELECT codigo, descripcion, stock, precio FROM productos";
	private static final String SQL_SELECT_STOCK = "SELECT stock FROM productos WHERE codigo = ?";
	private static final String SQL_UPDATE_STOCK = "UPDATE productos SET stock = ? WHERE codigo = ?";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}

	@Override
	public boolean insertar(Producto p) throws SQLException {
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {

			ps.setInt(1, p.getCodigo());
			ps.setString(2, p.getDescripcion());
			ps.setInt(3, p.getStock());
			ps.setDouble(4, p.getPrecio());

			return (ps.executeUpdate() > 0);
		}
	}

	@Override
	public List<Producto> buscarProductos(String texto) throws SQLException {
		List<Producto> productos = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SQL_SELECT_PRODUCTOS)) {
			ps.setString(1, texto);
			ps.setString(2, "%" + texto + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					productos.add(new Producto(rs.getInt("codigo"), rs.getString("descripcion"), rs.getInt("stock"),
							rs.getDouble("precio")));
				}
				return productos;
			}
		}
	}

	@Override
	public Producto buscarProducto(int codigo) throws SQLException {
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SQL_SELECT_PRODUCTO)) {
			ps.setInt(1, codigo);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Producto(rs.getInt("codigo"), rs.getString("descripcion"), rs.getInt("stock"),
							rs.getDouble("precio"));
				}
				return null;
			}
		}
	}

	@Override
	public boolean actualizarStock(int codigo, int stock) throws SQLException {
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_STOCK)) {
			ps.setInt(1, stock);
			ps.setInt(2, codigo);

			return (ps.executeUpdate() > 0);
		}
	}

	@Override
	public List<Producto> obtenerTodos() throws SQLException {
		List<Producto> productos = new ArrayList<Producto>();
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SQL_SELECT_TODO)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					productos.add(new Producto(rs.getInt("codigo"), rs.getString("descripcion"), rs.getInt("stock"),
							rs.getDouble("precio")));
				}
				return productos;
			}
		}
	}

	@Override
	public double procesarCompra(Map<Producto, Integer> carrito) throws SQLException {
		try (Connection conn = getConnection()) {
			double totalTicket = 0.0;
			conn.setAutoCommit(false); // Iniciamos transacción anulando autocommit

			try (PreparedStatement psSelect = conn.prepareStatement(SQL_SELECT_STOCK);
					PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE_STOCK)) {

				for (Map.Entry<Producto, Integer> elemento : carrito.entrySet()) {
					Producto p = elemento.getKey();
					int cantidad = elemento.getValue();

					psSelect.setInt(1, p.getCodigo());
					int stock = 0;
					try (ResultSet rs = psSelect.executeQuery()) {
						if (rs.next()) { // Si existe el producto
							stock = rs.getInt("stock");
							if (stock < cantidad) { // Sin stock suficiente
								conn.rollback();
								return 0.0;
							}
						} else { // Producto no encontrado
							conn.rollback();
							return 0.0;
						}
					}

					// Restamos la cantidad del stock
					psUpdate.setInt(1, stock - cantidad);
					psUpdate.setInt(2, p.getCodigo());
					if (psUpdate.executeUpdate() == 0) {
						conn.rollback(); // Error al actualizar el stock
						return 0.0;
					}
					totalTicket += p.getPrecio() * cantidad;
				}
				conn.commit();
				return totalTicket; // Todo ha ido bien
			} catch (SQLException e) {
				// Si algo explota en mitad del bucle, aseguramos el rollback total
				conn.rollback(); 
				// Y ahora sí, propagamos manualmente la excepción hacia la aplicación
				throw e;
			} finally {
				conn.setAutoCommit(true);
			}
		} 
	}
}
