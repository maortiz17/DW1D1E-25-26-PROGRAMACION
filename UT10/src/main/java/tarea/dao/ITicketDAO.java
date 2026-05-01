package tarea.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import tarea.entities.LineaTicket;
import tarea.entities.Producto;
import tarea.entities.Ticket;

public interface ITicketDAO {
	Ticket crear(Connection con, Ticket ticket) throws SQLException;
    Ticket buscar(Connection con, long id) throws SQLException;
}
