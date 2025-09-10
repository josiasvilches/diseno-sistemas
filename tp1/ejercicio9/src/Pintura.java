public class Pintura extends ObraDeArte {
    private String tipoPintura; // Óleo, acuarela...
    private String soporte; // Lienzo, papel...
    private String estilo;

    public Pintura(String id, String titulo, Artista artista, Origen origen, EstadoPertenencia estado, String tipoPintura, String soporte, String estilo) {
        super(id, titulo, artista, origen, estado);
        this.tipoPintura = tipoPintura;
        this.soporte = soporte;
        this.estilo = estilo;
    }
}