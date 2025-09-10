import java.time.LocalDate;

public class Permanente implements EstadoPertenencia {
    private LocalDate fechaAdquisicion;
    private double coste;
    private boolean enExposicion;

    public Permanente(LocalDate fechaAdquisicion, double coste, boolean enExposicion) {
        this.fechaAdquisicion = fechaAdquisicion;
        this.coste = coste;
        this.enExposicion = enExposicion;
    }

    @Override
    public String getEstado() {
        return "Colección Permanente";
    }

    @Override
    public String getDetalles() {
        return "Adquirido: " + fechaAdquisicion + ", Ubicación: " + (enExposicion ? "En Exposición" : "En Almacén");
    }
}