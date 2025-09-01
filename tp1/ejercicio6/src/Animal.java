import java.util.ArrayList;
import java.util.List;

public abstract class Animal extends Especie {
    private String periodoCelo;
    private List<Especie> seAlimentaDe;

    public Animal(String nombreCientifico, String nombreVulgar, String periodoCelo) {
        super(nombreCientifico, nombreVulgar);
        this.periodoCelo = periodoCelo;
        this.seAlimentaDe = new ArrayList<>();
    }

    public void addAlimento(Especie alimento) { this.seAlimentaDe.add(alimento); }

    public String getPeriodoCelo() { return periodoCelo; }
    public void setPeriodoCelo(String periodoCelo) { this.periodoCelo = periodoCelo; }
    public List<Especie> getSeAlimentaDe() { return seAlimentaDe; }
}