import java.util.Objects;

public abstract class Persona {
    protected String nss; // Número de Seguridad Social
    protected String nombre;
    protected String direccion;
    protected String telefono;

    public Persona(String nss, String nombre, String direccion, String telefono) {
        this.nss = nss;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nss, persona.nss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nss);
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' + ", nss='" + nss + '\'';
    }
}