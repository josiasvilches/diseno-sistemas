import java.util.Objects;

public class Material {
    private String nombre;

    public Material(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(nombre, material.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}