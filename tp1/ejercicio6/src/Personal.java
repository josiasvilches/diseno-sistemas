public abstract class Personal {
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private double sueldo;
    private String nss;
    private Parque parqueDondeTrabaja;

    public Personal(String dni, String nombre, String direccion, String telefono, double sueldo, String nss, Parque parque) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.nss = nss;
        this.parqueDondeTrabaja = parque;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public Parque getParqueDondeTrabaja() { return parqueDondeTrabaja; }
}