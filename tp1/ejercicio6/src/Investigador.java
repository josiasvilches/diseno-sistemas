import java.util.ArrayList;
import java.util.List;

public class Investigador extends Personal {
    private String titulacion;
    private List<ParticipacionProyecto> participaciones;

    public Investigador(String dni, String nombre, String direccion, String telefono, double sueldo, String nss, Parque parque, String titulacion) {
        super(dni, nombre, direccion, telefono, sueldo, nss, parque);
        this.titulacion = titulacion;
        this.participaciones = new ArrayList<>();
    }

    public void addParticipacion(ParticipacionProyecto p) { this.participaciones.add(p); }

    public String getTitulacion() { return titulacion; }
    public void setTitulacion(String titulacion) { this.titulacion = titulacion; }
}