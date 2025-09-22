import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Lider extends Vendedor {
    private Set<Vendedor> equipo;

    public Lider(String nombre, String direccion, String telefono, String cuitCuil, LocalDate fechaIncorporacion, LocalDate fechaPromocion) {
        super(nombre, direccion, telefono, cuitCuil, fechaIncorporacion);
        super.setFechaPromocionLider(fechaPromocion);
        this.equipo = new HashSet<>();
    }

    public void agregarVendedorAEquipo(Vendedor vendedor) {
        this.equipo.add(vendedor);
    }

    public double calcularVentasEquipoDesde(LocalDate fecha) {
        double totalEquipo = 0.0;
        for (Vendedor vendedor : equipo) {
            totalEquipo += vendedor.calcularVentasDesde(fecha);
        }
        return totalEquipo;
    }
}