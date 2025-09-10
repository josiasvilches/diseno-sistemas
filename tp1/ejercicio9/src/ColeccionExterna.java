import java.util.Objects;

public class ColeccionExterna {
    private String nombre; // Único
    private String tipo; // Museo, colección privada...
    private String descripcion;
    private String direccion;
    private String telefono;
    private String personaContacto;

    public ColeccionExterna(String nombre, String tipo, String direccion, String personaContacto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = direccion;
        this.personaContacto = personaContacto;
    }

    public String getNombre() {
        return nombre;
    }

    // Otros getters y setters...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColeccionExterna that = (ColeccionExterna) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}