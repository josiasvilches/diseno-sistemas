import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parque {
    private String nombre;
    private LocalDate fechaDeclaracion;
    private List<ComunidadAutonoma> comunidades;
    private List<Area> areas;
    private List<Alojamiento> alojamientos;
    private List<Personal> personal;
    private List<Entrada> entradas;

    public Parque(String nombre, LocalDate fechaDeclaracion) {
        this.nombre = nombre;
        this.fechaDeclaracion = fechaDeclaracion;
        this.comunidades = new ArrayList<>();
        this.areas = new ArrayList<>();
        this.alojamientos = new ArrayList<>();
        this.personal = new ArrayList<>();
        this.entradas = new ArrayList<>();
    }

    public void addComunidad(ComunidadAutonoma ca) { this.comunidades.add(ca); }
    public void addArea(Area area) { this.areas.add(area); }
    public void addAlojamiento(Alojamiento alojamiento) { this.alojamientos.add(alojamiento); }
    public void addPersonal(Personal p) { this.personal.add(p); }
    public void addEntrada(Entrada e) { this.entradas.add(e); }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public LocalDate getFechaDeclaracion() { return fechaDeclaracion; }
    public void setFechaDeclaracion(LocalDate fechaDeclaracion) { this.fechaDeclaracion = fechaDeclaracion; }
    public List<ComunidadAutonoma> getComunidades() { return comunidades; }
    public List<Area> getAreas() { return areas; }
}