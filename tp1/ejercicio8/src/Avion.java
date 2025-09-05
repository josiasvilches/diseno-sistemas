import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Avion {
    private String matricula;
    private TipoAvion tipoAvion;
    private Hangar hangar;
    private Set<PropietarioAvion> propietarios;
    private Set<Servicio> servicios;

    public Avion(String matricula, TipoAvion tipoAvion) {
        this.matricula = matricula;
        this.tipoAvion = tipoAvion;
        this.propietarios = new HashSet<>();
        this.servicios = new HashSet<>();
    }

    // Metodo para añadir un propietario con su fecha de adquisición
    public void agregarPropietario(PropietarioAvion propiedad) {
        this.propietarios.add(propiedad);
    }

    // Metodo para añadir un servicio
    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoAvion getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(TipoAvion tipoAvion) {
        this.tipoAvion = tipoAvion;
    }


    public Hangar getHangar() {
        return hangar;
    }

    // El hangar se asigna desde la clase Hangar para mantener consistencia
    public void setHangar(Hangar hangar) {
        this.hangar = hangar;
    }

    public Set<PropietarioAvion> getPropietarios() {
        return propietarios;
    }

    public Set<Servicio> getServicios() {
        return servicios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avion avion = (Avion) o;
        return Objects.equals(matricula, avion.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }


    @Override
    public String toString() {
        return "Avion{" +
                "matricula='" + matricula + '\'' +
                ", tipoAvion=" + tipoAvion.getModelo() +
                ", hangar=" + (hangar != null ? hangar.getNumero() : "N/A") +
                '}';
    }
}