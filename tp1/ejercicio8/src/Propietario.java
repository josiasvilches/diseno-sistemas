public class Propietario extends Persona {
    public Propietario(String nss, String nombre, String direccion, String telefono) {
        super(nss, nombre, direccion, telefono);
    }

    @Override
    public String toString() {
        return "Propietario{" + super.toString() + "}";
    }
}