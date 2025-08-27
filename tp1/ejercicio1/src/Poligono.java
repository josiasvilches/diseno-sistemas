import java.util.List;

public class Poligono extends Figura {
    protected List<Lado> lados;

    public Poligono(String nombre, List<Lado> lados) {
        super(nombre);
        if (lados.size() < 3) throw new IllegalArgumentException("Un polígono debe tener al menos 3 lados.");
        this.lados = lados;
    }
}