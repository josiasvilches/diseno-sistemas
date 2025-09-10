import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Museo Emiliano Guiñazú - Casa de Fader ");

        // 1. Crear Artistas Mendocinos
        Artista fader = new Artista(
                "Fernando Fader",
                LocalDate.of(1882, 4, 11),
                "Argentina",
                "Postimpresionismo",
                "Postimpresionismo"
        );
        fader.setFechaDefuncion(LocalDate.of(1935, 2, 28));

        Artista roigMatons = new Artista(
                "Fidel Roig Matóns",
                LocalDate.of(1887, 5, 27),
                "España",
                "Naturalismo",
                "Pintura de fauna"
        );
        roigMatons.setFechaDefuncion(LocalDate.of(1977, 5, 26));

        // 2. Crear Colecciones Externas con las que se colabora
        ColeccionExterna malba = new ColeccionExterna(
                "MALBA",
                "Museo",
                "Av. Figueroa Alcorta 3415, CABA",
                "Eduardo Costantini"
        );

        // 3. Crear Obras de Arte

        // Obra permanente del museo
        Origen origenArg = new Origen("Argentina", "Criolla", "Modernismo");
        Permanente estadoPermanenteFader = new Permanente(
                LocalDate.of(1951, 8, 15),
                50000.0,
                true
        );
        Pintura losChivatos = new Pintura(
                "P-FAD-001",
                "Los Chivatos",
                fader,
                origenArg,
                estadoPermanenteFader,
                "Óleo",
                "Lienzo",
                "Postimpresionismo"
        );
        losChivatos.setAnioCreacion(1907);

        // Obra en préstamo
        Origen origenEsp = new Origen("España", "Catalana", "Modernismo");
        Prestada estadoPrestamoRoig = new Prestada(
                malba,
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 9, 1)
        );
        Pintura condor = new Pintura(
                "P-ROI-015",
                "El Cóndor Herido",
                roigMatons,
                origenEsp,
                estadoPrestamoRoig,
                "Óleo",
                "Lienzo",
                "Naturalismo"
        );
        condor.setAnioCreacion(1914);

        // 4. Crear una Exposición
        Exposicion expoPaisajes = new Exposicion(
                "Paisajes de Cuyo: Una Mirada Íntima",
                LocalDate.of(2025, 7, 9),
                LocalDate.of(2025, 12, 15)
        );

        // 5. Agregar obras a la exposición
        expoPaisajes.agregarObra(losChivatos);
        expoPaisajes.agregarObra(condor);

        // 6. Mostrar Información
        System.out.println("\n--- DETALLES DE LAS OBRAS ---");
        System.out.println("Obra: " + losChivatos.getTitulo());
        System.out.println("  -> Artista: " + losChivatos.getArtista().getNombre());
        System.out.println("  -> Pertenencia: " + losChivatos.getDetallesPertenencia());

        System.out.println("\nObra: " + condor.getTitulo());
        System.out.println("  -> Artista: " + condor.getArtista().getNombre());
        System.out.println("  -> Pertenencia: " + condor.getDetallesPertenencia());

        System.out.println("\n--- EXPOSICIONES ACTUALES ---");
        expoPaisajes.mostrarObras();
    }
}