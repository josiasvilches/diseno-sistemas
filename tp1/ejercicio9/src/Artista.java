import java.time.LocalDate;
import java.util.Objects;

public class Artista {
    private String nombre; // Se asume único
    private LocalDate fechaNacimiento;
    private LocalDate fechaDefuncion; // Puede ser null
    private String paisOrigen;
    private String epoca;
    private String estiloPrincipal;
    private String descripcion;

    public Artista(String nombre, LocalDate fechaNacimiento, String paisOrigen, String epoca, String estiloPrincipal) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.paisOrigen = paisOrigen;
        this.epoca = epoca;
        this.estiloPrincipal = estiloPrincipal;
    }

    // Getters y Setters (incluyendo para fechaDefuncion y descripcion)
    public String getNombre() {
        return nombre;
    }

    public void setFechaDefuncion(LocalDate fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(nombre, artista.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + paisOrigen + ")";
    }
}