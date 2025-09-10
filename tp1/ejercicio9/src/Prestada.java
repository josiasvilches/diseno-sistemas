import java.time.LocalDate;

public class Prestada implements EstadoPertenencia {
    private ColeccionExterna coleccionOrigen;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestada(ColeccionExterna coleccionOrigen, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.coleccionOrigen = coleccionOrigen;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String getEstado() {
        return "En Préstamo";
    }

    @Override
    public String getDetalles() {
        return "Prestado por: " + coleccionOrigen.getNombre() + " hasta " + fechaDevolucion;
    }
}