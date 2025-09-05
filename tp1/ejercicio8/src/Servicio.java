import java.time.LocalDate;
import java.util.Objects;

public class Servicio {
    private LocalDate fecha;
    private int horasInvertidas;
    private String tipoTrabajo;
    private Mecanico mecanico;
    private Avion avion;

    public Servicio(LocalDate fecha, int horasInvertidas, String tipoTrabajo, Mecanico mecanico, Avion avion) {
        this.fecha = fecha;
        this.horasInvertidas = horasInvertidas;
        this.tipoTrabajo = tipoTrabajo;
        this.mecanico = mecanico;
        this.avion = avion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        // La restricción clave: mismo avión, misma fecha y mismo tipo de trabajo
        return Objects.equals(fecha, servicio.fecha) &&
                Objects.equals(tipoTrabajo, servicio.tipoTrabajo) &&
                Objects.equals(avion, servicio.avion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, tipoTrabajo, avion);
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "fecha=" + fecha +
                ", tipoTrabajo='" + tipoTrabajo + '\'' +
                ", mecanico=" + mecanico.getNombre() +
                '}';
    }
}