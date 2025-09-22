import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Crear la Empresa
        Empresa cosmeticaNatural = new Empresa("Cosmética Natural", 0.15); // 15% de comisión

        // 2. Crear Productos
        Producto cremaFacial = new Producto("Crema Hidratante de Malbec", 2500.0);
        Producto serumOjos = new Producto("Serum Contorno de Ojos", 3200.0);
        cosmeticaNatural.agregarProducto(cremaFacial);
        cosmeticaNatural.agregarProducto(serumOjos);

        // 3. Crear Representantes
        Vendedor anaGomez = new Vendedor("Ana Gómez", "San Martín 123", "261-111-1111", "27-12345678-5", LocalDate.of(2022, 5, 10));
        Vendedor juanPerez = new Vendedor("Juan Pérez", "Las Heras 456", "261-222-2222", "20-23456789-1", LocalDate.of(2023, 1, 15));

        Lider lauraDiaz = new Lider("Laura Díaz", "Belgrano 789", "261-333-3333", "27-34567890-2", LocalDate.of(2021, 3, 20), LocalDate.of(2023, 6, 1));

        // 4. Asignar equipos y agregar a la empresa
        lauraDiaz.agregarVendedorAEquipo(anaGomez);
        lauraDiaz.agregarVendedorAEquipo(juanPerez);

        cosmeticaNatural.agregarRepresentante(anaGomez);
        cosmeticaNatural.agregarRepresentante(juanPerez);
        cosmeticaNatural.agregarRepresentante(lauraDiaz);

        // 5. Simular Ventas (Tickets)
        // Ventas de Ana (Vendedora del equipo de Laura)
        anaGomez.registrarTicket(new TicketVenta(LocalDate.now().minusDays(10), cremaFacial));
        anaGomez.registrarTicket(new TicketVenta(LocalDate.now().minusDays(5), serumOjos));

        // Ventas de Juan (Vendedor del equipo de Laura)
        juanPerez.registrarTicket(new TicketVenta(LocalDate.now().minusDays(8), cremaFacial));

        // Ventas de Laura (Líder)
        lauraDiaz.registrarTicket(new TicketVenta(LocalDate.now().minusDays(12), serumOjos));
        lauraDiaz.registrarTicket(new TicketVenta(LocalDate.now().minusDays(2), cremaFacial));
        lauraDiaz.registrarTicket(new TicketVenta(LocalDate.now().minusDays(1), cremaFacial));

        // 6. Establecer fechas de reunión y calcular comisiones
        cosmeticaNatural.setFechasReunion(LocalDate.now().minusDays(30), LocalDate.now().plusDays(30));
        cosmeticaNatural.calcularYMostrarComisiones();
    }
}