import java.util.List;

public class Pastura extends Cereal {
    public Pastura(String nombre, List<String> mineralesRequeridos) {
        super(nombre, mineralesRequeridos);
    }

    @Override
    public boolean puedeSembrarseEn(Lote lote) {
        return super.puedeSembrarseEn(lote) && !lote.seSembroPastura();
    }
}