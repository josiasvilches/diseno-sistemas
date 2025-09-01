public class Vegetal extends Especie {
    private boolean tieneFloracion;
    private String periodoFloracion;

    public Vegetal(String nombreCientifico, String nombreVulgar, boolean tieneFloracion, String periodoFloracion) {
        super(nombreCientifico, nombreVulgar);
        this.tieneFloracion = tieneFloracion;
        this.periodoFloracion = tieneFloracion ? periodoFloracion : "No aplica";
    }

    public boolean isTieneFloracion() { return tieneFloracion; }
    public void setTieneFloracion(boolean tieneFloracion) { this.tieneFloracion = tieneFloracion; }
    public String getPeriodoFloracion() { return periodoFloracion; }
    public void setPeriodoFloracion(String periodoFloracion) { this.periodoFloracion = periodoFloracion; }
}