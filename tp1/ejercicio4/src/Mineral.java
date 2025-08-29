public class Mineral {
    private String nombre;
    private boolean esPrimario;

    public Mineral(String nombre, boolean esPrimario) {
        this.nombre = nombre;
        this.esPrimario = esPrimario;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esPrimario() {
        return esPrimario;
    }
}