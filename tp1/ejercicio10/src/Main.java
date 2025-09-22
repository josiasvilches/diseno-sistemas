import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // 1. Crear la Sede Olímpica en Mendoza
        // Usamos un año futuro hipotético para los juegos.
        SedeOlimpica sede = new SedeOlimpica("Mendoza", 2036, 95000000);

        // 2. Crear Materiales y Comisarios (con nombres locales)
        Material porterias = new Material("Porterías de Fútbol");
        Material testimonioRelevo = new Material("Testimonio de Relevos");
        Material redVoley = new Material("Red de Voleibol de Pista");

        Comisario juezPrincipal = new Comisario("J001", "Javier Gómez");
        Comisario asistentePista = new Comisario("A005", "Valentina Rojas");

        // 3. Crear Eventos
        Evento finalFutbol = new Evento(
                "Gran Final de Fútbol Masculino",
                LocalDateTime.of(2036, 7, 28, 21, 0),
                120,
                22
        );
        finalFutbol.agregarMaterial(porterias);
        finalFutbol.asignarComisario(juezPrincipal);

        Evento carreraPostas = new Evento(
                "Final de Relevos 4x100m Femenino",
                LocalDateTime.of(2036, 7, 30, 19, 30),
                3,
                32 // 8 equipos de 4
        );
        carreraPostas.agregarMaterial(testimonioRelevo);
        carreraPostas.asignarComisario(juezPrincipal);
        carreraPostas.asignarComisario(asistentePista);

        Evento finalVoley = new Evento(
                "Final de Voleibol de Pista Masculino",
                LocalDateTime.of(2036, 8, 2, 20, 0),
                150,
                12
        );
        finalVoley.agregarMaterial(redVoley);
        finalVoley.asignarComisario(asistentePista);


        // 4. Crear Complejos Deportivos de Mendoza
        Polideportivo malvinasArgentinas = new Polideportivo(
                "Estadio Malvinas Argentinas",
                "Parque General San Martín",
                "Ricardo Flores",
                75000
        );
        malvinasArgentinas.agregarArea("Fútbol", "Campo de juego principal");
        malvinasArgentinas.agregarArea("Atletismo", "Pista olímpica");
        malvinasArgentinas.agregarEvento(finalFutbol);
        malvinasArgentinas.agregarEvento(carreraPostas);

        Unideportivo aconcaguaArena = new Unideportivo(
                "Aconcagua Arena",
                "Parque General San Martín",
                "Mariana Sosa",
                30000,
                "Voleibol de Pista"
        );
        aconcaguaArena.agregarEvento(finalVoley);


        // 5. Agregar los complejos a la sede de Mendoza
        sede.agregarComplejo(malvinasArgentinas);
        sede.agregarComplejo(aconcaguaArena);

        // 6. Mostrar toda la información de la sede
        sede.mostrarInformacion();

        // 7. Demostrar la relación bidireccional Comisario <-> Evento
        System.out.println("\n============== TAREAS DE LOS COMISARIOS ==============");
        System.out.println("Eventos asignados a " + juezPrincipal.getNombre() + ":");
        for (Evento evento : juezPrincipal.getEventosAsignados()) {
            System.out.println("  - " + evento.getNombre());
        }

        System.out.println("\nEventos asignados a " + asistentePista.getNombre() + ":");
        for (Evento evento : asistentePista.getEventosAsignados()) {
            System.out.println("  - " + evento.getNombre());
        }
    }
}