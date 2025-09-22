// SedeOlimpica.java
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class SedeOlimpica {
    private String ciudadAnfitriona;
    private int anio;
    private double presupuesto;
    private Set<ComplejoDeportivo> complejos;

    public SedeOlimpica(String ciudadAnfitriona, int anio, double presupuesto) {
        this.ciudadAnfitriona = ciudadAnfitriona;
        this.anio = anio;
        this.presupuesto = presupuesto;
        this.complejos = new HashSet<>();
    }

    public void agregarComplejo(ComplejoDeportivo complejo) {
        this.complejos.add(complejo);
    }

    // El número de complejos se calcula dinámicamente
    public int getNumeroComplejos() {
        return this.complejos.size();
    }

    public void mostrarInformacion() {
        System.out.println("============== SEDE OLÍMPICA: " + ciudadAnfitriona + " " + anio + " ==============");
        System.out.println("Presupuesto: $" + (long) presupuesto);
        System.out.println("Número de complejos: " + getNumeroComplejos());
        System.out.println("----------------------------------------------------------");

        for (ComplejoDeportivo complejo : complejos) {
            System.out.println("\n>> COMPLEJO: " + complejo.getNombre() + " [" + complejo.getTipo() + "]");
            System.out.println("   Jefe de Organización: " + complejo.getJefeOrganizacion());
            System.out.println("   Áreas del complejo:");
            // Iteramos sobre el Map para mostrar las áreas
            for (Map.Entry<String, String> entry : complejo.getAreasDeporte().entrySet()) {
                System.out.println("     - Deporte: " + entry.getKey() + ", Ubicación: " + entry.getValue());
            }

            System.out.println("\n   Eventos programados:");
            for (Evento evento : complejo.getEventos()) {
                System.out.println("     EVENTO: " + evento.getNombre());
                System.out.println("       - Comisarios: " + evento.getComisarios());
                System.out.println("       - Material: " + evento.getMaterialNecesario());
            }
        }
    }
}