import java.util.HashSet;
import java.util.Set;

public class Mecanico extends Persona {
    private double salario;
    private Turno turno;
    private Set<TipoAvion> tiposAutorizados;

    public Mecanico(String nss, String nombre, String direccion, String telefono, double salario, Turno turno) {
        super(nss, nombre, direccion, telefono);
        this.salario = salario;
        this.turno = turno;
        this.tiposAutorizados = new HashSet<>(); // Inicializamos la colección
    }

    // Metodo para añadir tipos de avión autorizados
    public void agregarTipoAutorizado(TipoAvion tipo) {
        this.tiposAutorizados.add(tipo);
    }

    // Getters y Setters
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Set<TipoAvion> getTiposAutorizados() {
        return tiposAutorizados;
    }

    @Override
    public String toString() {
        return "Mecanico{" + super.toString() + ", salario=" + salario + ", turno=" + turno + '}';
    }
}