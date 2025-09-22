import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    public Cliente(String nombre, String direccion, String telefono, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(direccion, cliente.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, direccion);
    }

    @Override
    public String toString() {
        return nombre;
    }
}