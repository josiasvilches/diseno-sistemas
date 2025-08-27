import java.util.ArrayList;
import java.util.List;

public class Provincia {
    private List<Ciudad> ciudades = new ArrayList<>();
    private List<Provincia> provinciasLimitrofes = new ArrayList<>();
    private List<Pais> paisesLimitrofes = new ArrayList<>();

    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public void agregarProvinciaLimitrofe(Provincia provincia) {
        provinciasLimitrofes.add(provincia);
    }

    public void agregarPaisLimitrofe(Pais pais) {
        paisesLimitrofes.add(pais);
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public List<Provincia> getProvinciasLimitrofes() {
        return provinciasLimitrofes;
    }

    public List<Pais> getPaisesLimitrofes() {
        return paisesLimitrofes;
    }
}