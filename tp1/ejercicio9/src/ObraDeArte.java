import java.util.Objects;

public abstract class ObraDeArte {
    protected String id;
    protected String titulo;
    protected Artista artista;
    protected Integer anioCreacion; // Puede ser null
    protected String descripcion;
    protected Origen origen;
    protected EstadoPertenencia estado; // Composición

    public ObraDeArte(String id, String titulo, Artista artista, Origen origen, EstadoPertenencia estado) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.origen = origen;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setAnioCreacion(Integer anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Delegamos la obtención de detalles al objeto de estado
    public String getDetallesPertenencia() {
        return estado.getDetalles();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObraDeArte that = (ObraDeArte) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "'" + titulo + "' por " + artista.getNombre();
    }
}