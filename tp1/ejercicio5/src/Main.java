public class Main {
    public static void main(String[] args) {
        Ciudad ciudad = new Ciudad("Buenos Aires");
        Restaurante restaurante = new Restaurante("La Parrilla");
        Plato plato = new Plato("Milanesa");
        Sucursal sucursal = new Sucursal("Av. Siempre Viva 123", ciudad, restaurante);

        restaurante.agregarPlato(plato);
        restaurante.agregarSucursal(sucursal);
        ciudad.agregarRestaurante(restaurante);

        System.out.println("Ciudad: " + ciudad.getNombre());
        System.out.println("Restaurante: " + restaurante.getNombre());
        System.out.println("Plato: " + restaurante.getPlatos().get(0).getNombre());
        System.out.println("Sucursal: " + sucursal.getDireccion());
    }
}