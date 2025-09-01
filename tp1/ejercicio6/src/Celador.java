import java.util.ArrayList;
import java.util.List;

public class Celador extends Personal {
    private Entrada entradaAsignada;
    private List<VisitaParque> registros;

    public Celador(String dni, String nombre, String direccion, String telefono, double sueldo, String nss, Parque parque, Entrada entrada) {
        super(dni, nombre, direccion, telefono, sueldo, nss, parque);
        this.entradaAsignada = entrada;
        this.registros = new ArrayList<>();
    }

    public void registrarVisita(VisitaParque visita) {
        this.registros.add(visita);
    }

    public Entrada getEntradaAsignada() { return entradaAsignada; }
    public void setEntradaAsignada(Entrada entradaAsignada) { this.entradaAsignada = entradaAsignada; }
}