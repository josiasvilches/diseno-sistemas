import java.time.LocalDate;

public class Proyecto {
    private String nombre;
    private double presupuesto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    public Proyecto(String nombre, double presupuesto, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre; this.presupuesto = presupuesto; this.fechaInicio = fechaInicio; this.fechaFin = fechaFin;
    }
    public String getNombre() { return nombre; }
}