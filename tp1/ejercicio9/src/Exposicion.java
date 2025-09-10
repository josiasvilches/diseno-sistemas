import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Exposicion {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Set<ObraDeArte> obrasExhibidas; // Usamos Set para no tener obras duplicadas

    public Exposicion(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.obrasExhibidas = new HashSet<>();
    }

    public void agregarObra(ObraDeArte obra) {
        obrasExhibidas.add(obra);
    }

    public void mostrarObras() {
        System.out.println("Obras en la exposición '" + nombre + "':");
        for (ObraDeArte obra : obrasExhibidas) {
            System.out.println("  - " + obra.getTitulo() + " (" + obra.getArtista().getNombre() + ")");
        }
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
}