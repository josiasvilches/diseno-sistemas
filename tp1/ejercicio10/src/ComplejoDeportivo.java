import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class ComplejoDeportivo {
    protected String nombre;
    protected String localizacion;
    protected String jefeOrganizacion;
    protected double areaTotal;
    // Map<Deporte, Ubicacion> -> ¡Uso perfecto para un Map!
    protected Map<String, String> areasDeporte;
    protected Set<Evento> eventos;

    public ComplejoDeportivo(String nombre, String localizacion, String jefeOrganizacion, double areaTotal) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.jefeOrganizacion = jefeOrganizacion;
        this.areaTotal = areaTotal;
        this.areasDeporte = new HashMap<>();
        this.eventos = new HashSet<>();
    }

    public void agregarArea(String deporte, String ubicacion) {
        this.areasDeporte.put(deporte, ubicacion);
    }

    public void agregarEvento(Evento evento) {
        this.eventos.add(evento);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getJefeOrganizacion() {
        return jefeOrganizacion;
    }

    public Map<String, String> getAreasDeporte() {
        return areasDeporte;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    // Método abstracto que las clases hijas deberán implementar
    public abstract String getTipo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplejoDeportivo that = (ComplejoDeportivo) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}