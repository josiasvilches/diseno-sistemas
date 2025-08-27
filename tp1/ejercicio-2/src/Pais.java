import java.util.ArrayList;
import java.util.List;

public class Pais {
    private List<Pais> paisesLimitrofes = new ArrayList<>();
    private List<Ciudad> capitales = new ArrayList<>();
    private List<Provincia> provincias = new ArrayList<>();

    public void agregarPaisLimitrofe(Pais pais) {
        paisesLimitrofes.add(pais);
    }

    public void agregarCapital(Ciudad ciudad) {
        capitales.add(ciudad);
    }

    public void agregarProvincia(Provincia provincia) {
        provincias.add(provincia);
    }

    public List<Pais> getPaisesLimitrofes() {
        return paisesLimitrofes;
    }

    public List<Ciudad> getCapitales() {
        return capitales;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }
}