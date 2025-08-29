import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    private String nombre;
    private List<Restaurante> restaurantes;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.restaurantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void agregarRestaurante(Restaurante restaurante) {
        if (!restaurantes.contains(restaurante)) {
            restaurantes.add(restaurante);
        }
    }
}