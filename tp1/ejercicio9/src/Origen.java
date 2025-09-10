public class Origen {
    private String pais;
    private String cultura;
    private String epoca;

    public Origen(String pais, String cultura, String epoca) {
        this.pais = pais;
        this.cultura = cultura;
        this.epoca = epoca;
    }

    @Override
    public String toString() {
        return "Cultura " + cultura + " (" + epoca + ", " + pais + ")";
    }
}