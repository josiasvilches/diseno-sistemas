import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Empresa {
    private String nombre;
    private Map<String, Producto> productos; // Map para acceso rápido por nombre
    private Set<RepresentanteVentas> fuerzaDeVentas;
    private LocalDate ultimaReunion;
    private LocalDate proximaReunion;
    private double porcentajeComision;

    public Empresa(String nombre, double porcentajeComision) {
        this.nombre = nombre;
        this.porcentajeComision = porcentajeComision;
        this.productos = new HashMap<>();
        this.fuerzaDeVentas = new HashSet<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.put(producto.getNombre(), producto);
    }

    public void agregarRepresentante(RepresentanteVentas representante) {
        this.fuerzaDeVentas.add(representante);
    }

    public void setFechasReunion(LocalDate ultima, LocalDate proxima) {
        this.ultimaReunion = ultima;
        this.proximaReunion = proxima;
    }

    public void calcularYMostrarComisiones() {
        System.out.println("\n--- INFORME DE COMISIONES (desde " + ultimaReunion + ") ---");
        for (RepresentanteVentas rep : fuerzaDeVentas) {
            double ventasPropias = rep.calcularVentasDesde(ultimaReunion);
            double comisionPropia = ventasPropias * porcentajeComision;

            System.out.println("\nRepresentante: " + rep.getNombre());
            System.out.printf("  - Ventas Propias: $%.2f%n", ventasPropias);
            System.out.printf("  - Comisión por Ventas Propias: $%.2f%n", comisionPropia);

            if (rep instanceof Lider) {
                Lider lider = (Lider) rep;
                double ventasEquipo = lider.calcularVentasEquipoDesde(ultimaReunion);
                double comisionEquipo = ventasEquipo * porcentajeComision;
                System.out.printf("  - Ventas de su Equipo: $%.2f%n", ventasEquipo);
                System.out.printf("  - Comisión por Equipo: $%.2f%n", comisionEquipo);
                System.out.printf("  - TOTAL A RENDIR: $%.2f%n", (comisionPropia + comisionEquipo));
            } else {
                System.out.printf("  - TOTAL A RENDIR: $%.2f%n", comisionPropia);
            }
        }
    }
}