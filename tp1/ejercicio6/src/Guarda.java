public class Guarda extends Personal {
    private Area areaAsignada;
    private Vehiculo vehiculo;

    public Guarda(String dni, String nombre, String direccion, String telefono, double sueldo, String nss, Parque parque, Area areaAsignada, Vehiculo vehiculo) {
        super(dni, nombre, direccion, telefono, sueldo, nss, parque);
        this.areaAsignada = areaAsignada;
        this.vehiculo = vehiculo;
    }

    public Area getAreaAsignada() { return areaAsignada; }
    public void setAreaAsignada(Area areaAsignada) { this.areaAsignada = areaAsignada; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
}