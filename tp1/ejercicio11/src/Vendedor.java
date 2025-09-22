import java.time.LocalDate;

public class Vendedor extends RepresentanteVentas {
    private LocalDate fechaPromocionLider; // Puede ser null

    public Vendedor(String nombre, String direccion, String telefono, String cuitCuil, LocalDate fechaIncorporacion) {
        super(nombre, direccion, telefono, cuitCuil, fechaIncorporacion);
        this.fechaPromocionLider = null;
    }

    public void setFechaPromocionLider(LocalDate fechaPromocionLider) {
        this.fechaPromocionLider = fechaPromocionLider;
    }
}