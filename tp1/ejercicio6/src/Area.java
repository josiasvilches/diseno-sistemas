import java.util.ArrayList;
import java.util.List;

public class Area {
    private String nombre;
    private double km2;
    private List<Residencia> residencias; // Relación con Especie

    public Area(String nombre, double km2) {
        this.nombre = nombre;
        this.km2 = km2;
        this.residencias = new ArrayList<>();
    }

    public void addResidencia(Residencia residencia) { this.residencias.add(residencia); }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getKm2() { return km2; }
    public void setKm2(double km2) { this.km2 = km2; }
    public List<Residencia> getResidencias() { return residencias; }
}