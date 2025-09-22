import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Comisario {
    private String id;
    private String nombre;
    private Set<Evento> eventosAsignados;

    public Comisario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.eventosAsignados = new HashSet<>();
    }

    // Método para mantener la consistencia en la relación bidireccional
    public void agregarEvento(Evento evento) {
        this.eventosAsignados.add(evento);
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Evento> getEventosAsignados() {
        return eventosAsignados;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comisario comisario = (Comisario) o;
        return Objects.equals(id, comisario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}