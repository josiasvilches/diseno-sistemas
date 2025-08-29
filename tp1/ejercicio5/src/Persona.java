import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private List<Restaurante> restaurantesFrecuentados;
    private List<Gusto> gustos;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.restaurantesFrecuentados = new ArrayList<>();
        this.gustos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Restaurante> getRestaurantesFrecuentados() {
        return restaurantesFrecuentados;
    }

    public List<Gusto> getGustos() {
        return gustos;
    }

    public void agregarRestauranteFrecuentado(Restaurante restaurante) {
        if (!restaurantesFrecuentados.contains(restaurante)) {
            restaurantesFrecuentados.add(restaurante);
        }
    }

    public void agregarGusto(Gusto gusto) {
        if (!gustos.contains(gusto)) {
            gustos.add(gusto);
        }
    }
}