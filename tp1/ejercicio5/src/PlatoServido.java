public class PlatoServido {
    private Plato plato;
    private Restaurante restaurante;

    public PlatoServido(Plato plato, Restaurante restaurante) {
        this.plato = plato;
        this.restaurante = restaurante;
    }

    public Plato getPlato() {
        return plato;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
}