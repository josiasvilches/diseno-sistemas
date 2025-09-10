public class Escultura extends ObraDeArte {
    private String material;
    private double altura; // en cm
    private double peso;   // en kg
    private String estilo;

    public Escultura(String id, String titulo, Artista artista, Origen origen, EstadoPertenencia estado, String material, double altura, double peso, String estilo) {
        super(id, titulo, artista, origen, estado);
        this.material = material;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
    }
}