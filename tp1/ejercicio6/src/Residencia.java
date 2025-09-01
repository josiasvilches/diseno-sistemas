public class Residencia {
    private int numeroIndividuos;
    private Especie especie;
    private Area area;

    public Residencia(int numeroIndividuos, Especie especie, Area area) {
        this.numeroIndividuos = numeroIndividuos;
        this.especie = especie;
        this.area = area;
    }
    public int getNumeroIndividuos() { return numeroIndividuos; }
    public Especie getEspecie() { return especie; }
    public Area getArea() { return area; }
}