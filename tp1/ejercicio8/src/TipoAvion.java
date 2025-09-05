// TipoAvion.java
import java.util.Objects;

public class TipoAvion {
    private String modelo;
    private int capacidad;
    private double peso;

    public TipoAvion(String modelo, int capacidad, double peso) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.peso = peso;
    }

    // Getters y Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoAvion tipoAvion = (TipoAvion) o;
        return Objects.equals(modelo, tipoAvion.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo);
    }

    @Override
    public String toString() {
        return "TipoAvion{modelo='" + modelo + "'}";
    }
}