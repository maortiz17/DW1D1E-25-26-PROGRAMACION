package tarea.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import tarea.entities.LineaTicket;
import tarea.entities.Producto;

public interface ILineaTicketDAO {
    // Se llama dentro de la transacción de venta
    LineaTicket crear(Connection con, LineaTicket linea) throws SQLException;
    
    // Útil si al continuar una venta queremos sobrescribir líneas antes de guardar
    boolean borrar(Connection con, long id) throws SQLException;
    
    LineaTicket buscar(Connection con, long id) throws SQLException;
    
    List<LineaTicket> buscarPorTicket(Connection con, long id) throws SQLException;
}
