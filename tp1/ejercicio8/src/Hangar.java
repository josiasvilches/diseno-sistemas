import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hangar {
    private int numero;
    private int capacidad;
    private String ubicacion;
    private Set<Avion> aviones;

    public Hangar(int numero, int capacidad, String ubicacion) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.aviones = new HashSet<>();
    }

    // Metodo para agregar un avión al hangar
    public void agregarAvion(Avion avion) {
        if (aviones.size() < capacidad) {
            this.aviones.add(avion);
            avion.setHangar(this); // Asignación bidireccional
        } else {
            System.out.println("El hangar " + numero + " está lleno.");
        }
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<Avion> getAviones() {
        return aviones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hangar hangar = (Hangar) o;
        return numero == hangar.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Hangar{numero=" + numero + ", ubicacion='" + ubicacion + "'}";
    }
}