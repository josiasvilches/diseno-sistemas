public class Polideportivo extends ComplejoDeportivo {

    public Polideportivo(String nombre, String localizacion, String jefeOrganizacion, double areaTotal) {
        super(nombre, localizacion, jefeOrganizacion, areaTotal);
    }

    @Override
    public String getTipo() {
        return "Polideportivo";
    }
}