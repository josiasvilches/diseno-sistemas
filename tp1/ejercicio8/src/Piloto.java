import java.util.HashSet;
import java.util.Set;

public class Piloto extends Persona {
    private String licencia;
    private String restricciones;
    private Set<TipoAvion> tiposAutorizados;

    public Piloto(String nss, String nombre, String direccion, String telefono, String licencia, String restricciones) {
        super(nss, nombre, direccion, telefono);
        this.licencia = licencia;
        this.restricciones = restricciones;
        this.tiposAutorizados = new HashSet<>();
    }

    // Metodo para añadir tipos de avión autorizados
    public void agregarTipoAutorizado(TipoAvion tipo) {
        this.tiposAutorizados.add(tipo);
    }

    // Getters y Setters
    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public Set<TipoAvion> getTiposAutorizados() {
        return tiposAutorizados;
    }

    @Override
    public String toString() {
        return "Piloto{" + super.toString() + ", licencia='" + licencia + '\'' + '}';
    }
}