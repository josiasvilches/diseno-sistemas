import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Evento {
    private String nombre;
    private LocalDateTime fecha;
    private int duracionMinutos;
    private int numeroParticipantes;
    private Set<Comisario> comisarios;
    private Set<Material> materialNecesario;

    public Evento(String nombre, LocalDateTime fecha, int duracionMinutos, int numeroParticipantes) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracionMinutos = duracionMinutos;
        this.numeroParticipantes = numeroParticipantes;
        this.comisarios = new HashSet<>();
        this.materialNecesario = new HashSet<>();
    }

    public void agregarMaterial(Material material) {
        this.materialNecesario.add(material);
    }

    // Método para asignar un comisario y mantener la relación bidireccional
    public void asignarComisario(Comisario comisario) {
        this.comisarios.add(comisario);
        comisario.agregarEvento(this); // Importante: actualiza el otro lado de la relación
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Set<Comisario> getComisarios() {
        return comisarios;
    }

    public Set<Material> getMaterialNecesario() {
        return materialNecesario;
    }

    @Override
    public String toString() {
        return nombre + " - " + fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(nombre, evento.nombre) && Objects.equals(fecha, evento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fecha);
    }
}