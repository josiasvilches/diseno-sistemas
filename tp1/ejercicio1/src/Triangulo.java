import java.util.List;
public class Triangulo extends Poligono {
    public Triangulo(String nombre, List<Lado> lados) {
        super(nombre, lados);
        if (lados.size() != 3) throw new IllegalArgumentException("Un triángulo debe tener 3 lados.");
    }
}
