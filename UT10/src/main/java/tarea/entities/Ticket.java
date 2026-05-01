package tarea.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private long id;
	private LocalDateTime fechaHora;
	private boolean ticketCerrado;
	private List<LineaTicket> lineas;
	
	public Ticket(LocalDateTime fechahora, boolean ticketcerrado, List<LineaTicket> lineas) {
        this.fechaHora = fechahora;
        this.ticketCerrado = ticketcerrado;
        this.lineas = copiarLineas(lineas);
    }

    public Ticket(long id, LocalDateTime fechahora, boolean ticketcerrado, List<LineaTicket> lineas) {
        this(fechahora, ticketcerrado, lineas);
        this.id = id;
    }

	public long getId() {
		return id;
	}

	public LocalDateTime getFechahora() {
		return fechaHora;
	}

	public boolean isTicketcerrado() {
		return ticketCerrado;
	}

	public List<LineaTicket> getLineas() {
		return copiarLineas(lineas);
	}
    
    private List<LineaTicket> copiarLineas(List<LineaTicket> lineas){
    	if (lineas == null) return new ArrayList<>(); // Si no existe el objeto devuelvo lista vacía
    	// Copia defensiva de la lista y sus componentes
        List<LineaTicket> copiaLineas = new ArrayList<>(lineas.size());
        for (LineaTicket lineaTicket : lineas) {
        	copiaLineas.add(new LineaTicket(lineaTicket));
        }
        return copiaLineas;
    }
    
    @Override
    public String toString(){
    	StringBuilder ticket = new StringBuilder();
    	ticket.append(String.format("Ticket número: %d. Fecha y hora: %s\n\n", id, fechaHora));
    	ticket.append("-".repeat(50));
    	for (LineaTicket lineaTicket : lineas) {
    		ticket.append(lineaTicket);
    		ticket.append("\n");
    	}
    	return ticket.toString();
    }
}
