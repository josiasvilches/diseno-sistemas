import java.time.LocalDate;
import java.util.Objects;

public class PropietarioAvion {
    private Propietario propietario;
    private Avion avion;
    private LocalDate fechaAdquisicion;

    public PropietarioAvion(Propietario propietario, Avion avion, LocalDate fechaAdquisicion) {
        this.propietario = propietario;
        this.avion = avion;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    // Getter and Setter
    public Propietario getPropietario() {
        return propietario;
    }

    public Avion getAvion() {
        return avion;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropietarioAvion that = (PropietarioAvion) o;
        return Objects.equals(propietario, that.propietario) && Objects.equals(avion, that.avion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propietario, avion);
    }

    @Override
    public String toString() {
        return "PropietarioAvion{" +
                "propietario=" + propietario.getNombre() +
                ", fechaAdquisicion=" + fechaAdquisicion +
                '}';
    }
}