import java.util.List;

public class Cooperativa {
    private List<Lote> lotes;
    private List<Cereal> cereales;

    public Cooperativa(List<Lote> lotes, List<Cereal> cereales) {
        this.lotes = lotes;
        this.cereales = cereales;
    }

    public Cereal aconsejarCereal(Lote lote) {
        return cereales.stream()
                .filter(c -> c.puedeSembrarseEn(lote))
                .findFirst()
                .orElse(null);
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public List<Cereal> getCereales() {
        return cereales;
    }
}