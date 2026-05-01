package tarea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tarea.dao.ILineaTicketDAO;
import tarea.dao.IProductoDAO;
import tarea.entities.LineaTicket;
import tarea.entities.Producto;

public class LineaTicketDAOOracle implements ILineaTicketDAO {

	@Override
	public LineaTicket crear(Connection con, LineaTicket lt) throws SQLException {
		String query = "INSERT INTO lineaticket (ticket_id, producto_id, cantidad, precioventa) VALUES (?, ?, ?, ?)";
		String[] pk = { "id" };
		// En la llamada al método prepareStatement pasamos un Array con los campos que
		// componen la PD de la tabla
		// Así tendremos disponible el método getGeneratedKeys con la PK generada en el
		// INSERT
		try (PreparedStatement pstmt = con.prepareStatement(query, pk)) {
			pstmt.setLong(1, lt.getTicketId());
			pstmt.setLong(2, lt.getProducto().getId());
			pstmt.setInt(3, lt.getCantidad());
			pstmt.setDouble(4, lt.getPrecioVenta());

			int filasAfectadas = pstmt.executeUpdate();

			if (filasAfectadas > 0) {
				try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						long id = generatedKeys.getLong(1);
						return new LineaTicket(id, lt.getCantidad(), lt.getPrecioVenta(), lt.getProducto(), lt.getTicketId());
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean borrar(Connection con, long id) throws SQLException {
		String query = "DELETE FROM lineaticket WHERE id = ?";
        // Eliminamos el producto cuyo id se recibe como parámetro
        try(PreparedStatement pstmt = con.prepareStatement(query)){
            pstmt.setLong(1, id);

            return pstmt.executeUpdate() > 0;
        }
	}
	
	@Override
	public LineaTicket buscar(Connection con, long id) throws SQLException{
		String query = "SELECT id, producto_id, ticket_id, cantidad, precioventa FROM lineaticket WHERE id = ?";
        // Necesitamos un objeto ProductoOracleDAO para recuperar el producto que necesito para crear el objeto. 
		// Esto produce un acoplamiento entre esta clase y la implementación de la interfaz IproductoDAO, pero lo haremos
		// así por simplificar
        IProductoDAO pdo = new ProductoDAOOracle();
		try(PreparedStatement pstmt = con.prepareStatement(query)){
            pstmt.setLong(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                	Producto p = pdo.buscar(con, rs.getLong("producto_id"));
                    return new LineaTicket(rs.getLong("id"), rs.getInt("cantidad"), rs.getDouble("precioventa"), p, rs.getLong("ticket_id"));
                }
            }
        }
        return null;
	}
	
	@Override
	public List<LineaTicket> buscarPorTicket(Connection con, long ticket_id) throws SQLException{
		String query = "SELECT id, producto_id, ticket_id, cantidad, precioventa FROM lineaticket WHERE ticket_id = ?";
		// Necesitamos un objeto ProductoOracleDAO para recuperar el producto que necesito para crear el objeto. 
				// Esto produce un acoplamiento entre esta clase y la implementación de la interfaz IproductoDAO, pero lo haremos
				// así por simplificar
		        IProductoDAO pdo = new ProductoDAOOracle();
		        
		        // Lista con las líneas de ese ticket
		        List<LineaTicket> lineas = new ArrayList<>();
				try(PreparedStatement pstmt = con.prepareStatement(query)){
		            pstmt.setLong(1, ticket_id);
		            try(ResultSet rs = pstmt.executeQuery()){
		                while (rs.next()){
		                	Producto p = pdo.buscar(con, rs.getLong("producto_id"));
		                    lineas.add(new LineaTicket(rs.getLong("id"), rs.getInt("cantidad"), rs.getDouble("precioventa"), p, rs.getLong("ticket_id")));                
		                }
		            }
		        }
		        return lineas;
	}
}
