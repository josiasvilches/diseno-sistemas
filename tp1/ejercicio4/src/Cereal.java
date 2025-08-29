import java.util.List;

public abstract class Cereal {
    private String nombre;
    private List<String> mineralesRequeridos;

    public Cereal(String nombre, List<String> mineralesRequeridos) {
        this.nombre = nombre;
        this.mineralesRequeridos = mineralesRequeridos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getMineralesRequeridos() {
        return mineralesRequeridos;
    }

    public boolean puedeSembrarseEn(Lote lote) {
        return lote.tieneMinerales(mineralesRequeridos);
    }
}