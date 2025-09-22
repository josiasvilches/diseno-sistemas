public class Unideportivo extends ComplejoDeportivo {
    private String deporteUnico;

    public Unideportivo(String nombre, String localizacion, String jefeOrganizacion, double areaTotal, String deporteUnico) {
        super(nombre, localizacion, jefeOrganizacion, areaTotal);
        this.deporteUnico = deporteUnico;
        // Un complejo unideportivo solo tiene un área para su único deporte
        this.agregarArea(deporteUnico, "Instalación principal");
    }

    @Override
    public String getTipo() {
        return "Unideportivo (" + deporteUnico + ")";
    }
}