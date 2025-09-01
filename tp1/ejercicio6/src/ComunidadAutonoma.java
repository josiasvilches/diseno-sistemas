import java.util.ArrayList;
import java.util.List;

public class ComunidadAutonoma {
    private String nombre;
    private Organismo organismoResponsable;
    private List<Parque> parques;

    public ComunidadAutonoma(String nombre, Organismo organismoResponsable) {
        this.nombre = nombre;
        this.organismoResponsable = organismoResponsable;
        this.parques = new ArrayList<>();
    }

    public void addParque(Parque parque) {
        if (!this.parques.contains(parque)) {
            this.parques.add(parque);
        }
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Organismo getOrganismoResponsable() { return organismoResponsable; }
    public void setOrganismoResponsable(Organismo organismoResponsable) { this.organismoResponsable = organismoResponsable; }
    public List<Parque> getParques() { return parques; }
}