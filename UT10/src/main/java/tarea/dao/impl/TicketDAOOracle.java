package tarea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import tarea.dao.ILineaTicketDAO;
import tarea.dao.ITicketDAO;
import tarea.entities.LineaTicket;
import tarea.entities.Ticket;

public class TicketDAOOracle implements ITicketDAO{
	public Ticket crear(Connection con, Ticket ticket) throws SQLException, NullPointerException {
		if (con  == null) {
			throw new NullPointerException();
		}
		long id = 0;
		// Utilizamos una transacción. Para ello anulamos el autocommit
		try {
			con.setAutoCommit(false);
			String query = "INSERT INTO ticket (fechahora, ticketcerrado) VALUES (?,?)";
			String[] pk = {"id"};
			try(PreparedStatement pstmt = con.prepareStatement(query, pk)){
				pstmt.setObject(1, ticket.getFechahora());
				pstmt.setString(2, ticket.isTicketcerrado() ? "T" : "F");
				
				int filasAfectadas = pstmt.executeUpdate();

	            if (filasAfectadas > 0) {
	                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        id = generatedKeys.getLong(1);
	                    }
	                }
	            }
	            // Ya tenemos creado el ticket. Ahora vamos a insertar sus líneas en la tabla
	            query = "INSERT INTO lineaticket (cantidad, precioventa, producto_id, ticket_id) VALUES (?,?,?,?)";
	            try(PreparedStatement pstmt2 = con.prepareStatement(query)){
	            	for (LineaTicket lineaTicket : ticket.getLineas()) {
	            		pstmt2.setInt(1, lineaTicket.getCantidad());
	            		pstmt2.setDouble(2, lineaTicket.getPrecioVenta());
	            		pstmt2.setLong(3, lineaTicket.getProducto().getId());
	            		pstmt2.setLong(4, id);
	            		pstmt2.executeUpdate();
	            	}
	            }
	            con.commit();
	            return new Ticket(id, ticket.getFechahora(), ticket.isTicketcerrado(), ticket.getLineas());
			}
		}catch (SQLException e) {
	        if (con != null) con.rollback(); // Si algo falla, deshacemos todo
	        throw e;
		}finally {
	       con.setAutoCommit(true);
		}
	}
	
	public Ticket buscar(Connection con, long id) throws SQLException{
		String query = "SELECT id, fechahora, ticketcerrado FROM ticket WHERE id = ?";
        
        try(PreparedStatement pstmt = con.prepareStatement(query)){
            pstmt.setLong(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    // Ya tenemos los datos del ticket. Ahora buscamos sus líneas de detalle
                	// Volvemos a acoplar objetos por simplificar
                	ILineaTicketDAO lineaTicket = new LineaTicketDAOOracle();
                	List<LineaTicket> lineas = lineaTicket.buscarPorTicket(con, id);
                	return new Ticket(id, (LocalDateTime)rs.getObject("fechahora"), "T".equals(rs.getString("ticketcerrado")), lineas);
                }
            }
        }
        return null;
	}
}
