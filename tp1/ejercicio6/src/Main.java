import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Crear Organismo y Comunidad Autónoma
        Organismo orgMedioAmbiente = new Organismo("Ministerio de Medio Ambiente");
        ComunidadAutonoma mendoza = new ComunidadAutonoma("Mendoza", orgMedioAmbiente);

        // 2. Crear Parque Nacional
        Parque potrerillos = new Parque("Parque Nacional Potrerillos", LocalDate.of(2001, 10, 16));

        // 3. Establecer relaciones
        mendoza.addParque(potrerillos);
        potrerillos.addComunidad(mendoza);

        // 4. Crear Areas para el parque
        Area clubnautico = new Area("Club Náutico", 300);
        potrerillos.addArea(clubnautico);

        // 5. Crear Especies usando las clases específicas
        Carnivoro puma = new Carnivoro("Puma Concolor", "Puma", "Primavera");
        Herbivoro liebre = new Herbivoro("Lepus", "Liebre", "Todo el año");
        Vegetal jarilla = new Vegetal("Larrea", "Jarilla", true, "Primavera");

        // 6. Añadir Especies a las Areas
        Residencia residenciaPuma = new Residencia(50, puma, clubnautico);
        clubnautico.addResidencia(residenciaPuma);
        Residencia residenciaLiebre = new Residencia(2000, liebre, clubnautico);
        clubnautico.addResidencia(residenciaLiebre);

        // 7. Definir la cadena alimenticia
        puma.addAlimento(liebre);

        // 8. Crear Personal
        Vehiculo todoterreno = new Vehiculo("4x4", "AH-123-FG");
        Guarda guarda1 = new Guarda("22093485", "Juan Pérez", "Calle San Martín 123", "2618908764", 180000, "000000800293829", potrerillos, clubnautico, todoterreno);
        potrerillos.addPersonal(guarda1);

        // 9. Mostrar información para verificar
        System.out.println("--- Información del Parque Nacional ---");
        System.out.println("Parque: " + potrerillos.getNombre());
        System.out.println("\n--- Áreas del Parque ---");
        for (Area area : potrerillos.getAreas()) {
            System.out.println("- Área: " + area.getNombre());
            System.out.println("  Especies residentes:");
            for (Residencia r : area.getResidencias()) {
                System.out.println("    -> " + r.getEspecie().getNombreVulgar() + " (" + r.getNumeroIndividuos() + " individuos)");
            }
        }

        System.out.println("\n--- Personal ---");
        System.out.println("Guarda: " + guarda1.getNombre() + ", asignado al área: " + guarda1.getAreaAsignada().getNombre());

        System.out.println("\n--- Cadena Alimenticia ---");
        System.out.println("El " + puma.getNombreVulgar() + " se alimenta de: " + puma.getSeAlimentaDe().get(0).getNombreVulgar());
    }
}