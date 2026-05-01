package tarea.entities;

public class LineaTicket {
	private long id;
    private int cantidad;
    private double precioVenta;
    private Producto producto;
    private long ticketId;

    public LineaTicket(int cantidad, double precioVenta, Producto producto, long ticketId) {
    	this.cantidad = cantidad;
    	this.precioVenta = precioVenta;
    	this.producto = new Producto(producto);
    	this.ticketId = ticketId;
    }

    public LineaTicket(long id, int cantidad, double precioVenta, Producto producto, long ticketId) {
    	this(cantidad, precioVenta, producto, ticketId);
    	this.id = id;
    }
    
    // Constructor de copia
    public LineaTicket(LineaTicket lt) {
        this.cantidad = lt.cantidad;
        this.precioVenta = lt.precioVenta;
        this.ticketId = lt.ticketId;
        // ¡Importante! Copiamos el producto, no solo la referencia
        this.producto = new Producto(lt.getProducto());
    }

    
    public long getId() {
		return id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public long getTicketId() {
		return ticketId;
	}

	// Su getter también debería ser defensivo
    public Producto getProducto() {
        return new Producto(this.producto);
    }
    
    // Método toString. Se utilizará para imprimir el ticket
    @Override
    public String toString() {
        double subtotal = cantidad * precioVenta;
        return String.format("%d x %-20s @ %.2f€ | Subtotal: %.2f€", 
                             cantidad, producto.getNombre(), precioVenta, subtotal);
    }
}
