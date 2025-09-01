import java.util.ArrayList;
import java.util.List;

public class Alojamiento {
    private String nombre;
    private int capacidad;
    private String categoria;
    private List<Estancia> estancias;
    private List<Excursion> excursionesOrganizadas;

    public Alojamiento(String nombre, int capacidad, String categoria) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.categoria = categoria;
        this.estancias = new ArrayList<>();
        this.excursionesOrganizadas = new ArrayList<>();
    }

    public void addEstancia(Estancia estancia) { this.estancias.add(estancia); }
    public void addExcursion(Excursion excursion) { this.excursionesOrganizadas.add(excursion); }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}