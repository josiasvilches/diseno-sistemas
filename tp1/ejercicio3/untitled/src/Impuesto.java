public class Impuesto {
    protected String nombre;
    protected int monto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Impuesto() {

    }

    public Impuesto(String nombre, int monto) {
        this.nombre = nombre;
        this.monto = monto;
    }
}
