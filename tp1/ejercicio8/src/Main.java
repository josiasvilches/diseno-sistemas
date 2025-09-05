import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Crear Tipos de Avión
        TipoAvion cessna182 = new TipoAvion("Cessna 182", 4, 894);
        TipoAvion cessna320 = new TipoAvion("Cessna 320", 5, 1293);

        // 2. Crear Personal
        Mecanico mecanico1 = new Mecanico("00000080038495", "Carlos Pérez", "Avenida San Martín 2893", "261-685-9768", 1560000, Turno.MANANA);
        mecanico1.agregarTipoAutorizado(cessna182);

        Piloto piloto1 = new Piloto("00000080094857", "Ana Gómez", "Sargento Cabral 331", "261-435-3667", "LIC-987", "Ninguna");
        piloto1.agregarTipoAutorizado(cessna182);
        piloto1.agregarTipoAutorizado(cessna320);

        Propietario propietario1 = new Propietario("00000080092369", "Aerotec S.A", "Ruta 60 km 115", "496-3058");

        // 3. Crear Hangar
        Hangar hangarA1 = new Hangar(1, 5, "Sector Norte");

        // 4. Crear Aviones
        Avion avion1 = new Avion("EC-LJR", cessna182);

        // 5. Establecer Relaciones
        hangarA1.agregarAvion(avion1);

        // Relacionar propietario con avión y fecha
        PropietarioAvion propiedad = new PropietarioAvion(propietario1, avion1, LocalDate.of(2020, 5, 15));
        avion1.agregarPropietario(propiedad);

        // 6. Registrar Servicios
        Servicio servicio1 = new Servicio(LocalDate.now(), 8, "Revisión de motor", mecanico1, avion1);
        avion1.agregarServicio(servicio1);

        // Intentamos agregar un servicio duplicado (NO se añadirá gracias al Set y equals/hashCode)
        Servicio servicioDuplicado = new Servicio(LocalDate.now(), 10, "Revisión de motor", mecanico1, avion1);
        avion1.agregarServicio(servicioDuplicado);

        // 7. Mostrar Información
        System.out.println("Información del Aeródromo:");
        System.out.println("==========================");
        System.out.println("Avión: " + avion1.getMatricula());
        System.out.println("  -> Tipo: " + avion1.getTipoAvion().getModelo());
        System.out.println("  -> Hangar: " + avion1.getHangar().getUbicacion());
        System.out.println("  -> Propietarios:");
        for (PropietarioAvion pa : avion1.getPropietarios()) {
            System.out.println("    - " + pa.getPropietario().getNombre() + " (Adquirido: " + pa.getFechaAdquisicion() + ")");
        }

        System.out.println("\nServicios realizados al avión " + avion1.getMatricula() + ":");
        System.out.println("  -> Total de servicios: " + avion1.getServicios().size()); // Debería ser 1
        for (Servicio s : avion1.getServicios()) {
            System.out.println("    - " + s);
        }

        System.out.println("\nPilotos autorizados para " + cessna320.getModelo() + ":");
        if (piloto1.getTiposAutorizados().contains(cessna320)){
            System.out.println("  - " + piloto1.getNombre());
        }
    }
}