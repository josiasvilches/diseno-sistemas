import java.util.Objects;

public class Producto {
    private String nombre; // Identificador único
    private double precioVentaPublico;

    public Producto(String nombre, double precioVentaPublico) {
        this.nombre = nombre;
        this.precioVentaPublico = precioVentaPublico;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecioVentaPublico() {
        return precioVentaPublico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}