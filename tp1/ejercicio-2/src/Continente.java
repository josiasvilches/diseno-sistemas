import java.util.ArrayList;
import java.util.List;

public class Continente {
    private List<Pais> paises = new ArrayList<>();

    public void agregarPais(Pais pais) {
        paises.add(pais);
    }

    public List<Pais> getPaises() {
        return paises;
    }
}