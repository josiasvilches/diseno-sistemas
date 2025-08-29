import java.util.List;
import java.util.ArrayList;

public class Lote {
    private String nombre;
    private List<Mineral> minerales;
    private List<Cereal> cerealesSembrados;

    public Lote(String nombre, List<Mineral> minerales) {
        this.nombre = nombre;
        this.minerales = minerales;
        this.cerealesSembrados = new ArrayList<>();
    }

    public boolean esEspecial() {
        return minerales.stream().anyMatch(Mineral::esPrimario);
    }

    public boolean tieneMinerales(List<String> requeridos) {
        return requeridos.stream()
                .allMatch(req -> minerales.stream().anyMatch(m -> m.getNombre().equals(req)));
    }

    public void sembrar(Cereal cereal) {
        this.cerealesSembrados.add(cereal);
    }

    public boolean seSembroPastura() {
        return cerealesSembrados.stream().anyMatch(c -> c instanceof Pastura);
    }

    public List<Cereal> getCerealesSembrados() {
        return cerealesSembrados;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Mineral> getMinerales() {
        return minerales;
    }
}