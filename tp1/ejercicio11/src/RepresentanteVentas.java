import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public abstract class RepresentanteVentas {
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected LocalDate fechaNacimiento;
    protected String cuitCuil;
    protected LocalDate fechaIncorporacion;
    protected Set<Cliente> carteraClientes;
    protected List<TicketVenta> tickets;

    public RepresentanteVentas(String nombre, String direccion, String telefono, String cuitCuil, LocalDate fechaIncorporacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuitCuil = cuitCuil;
        this.fechaIncorporacion = fechaIncorporacion;
        this.carteraClientes = new HashSet<>();
        this.tickets = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        this.carteraClientes.add(cliente);
    }

    public void registrarTicket(TicketVenta ticket) {
        this.tickets.add(ticket);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<TicketVenta> getTickets() {
        return tickets;
    }

    // Método para calcular sus ventas en un período
    public double calcularVentasDesde(LocalDate fecha) {
        double total = 0.0;
        for (TicketVenta ticket : tickets) {
            if (ticket.getFecha().isAfter(fecha) || ticket.getFecha().isEqual(fecha)) {
                total += ticket.getPrecioPagado();
            }
        }
        return total;
    }
}