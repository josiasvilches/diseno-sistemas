import java.time.LocalDate;

public class TicketVenta {
    private LocalDate fecha;
    private Producto producto;
    private double precioPagado;
    private Cliente cliente; // Se completa después de la venta final

    public TicketVenta(LocalDate fecha, Producto producto) {
        this.fecha = fecha;
        this.producto = producto;
        this.precioPagado = producto.getPrecioVentaPublico();
    }

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public double getPrecioPagado() {
        return precioPagado;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}