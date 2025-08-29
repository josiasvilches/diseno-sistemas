public class Sucursal {
    private String direccion;
    private Ciudad ciudad;
    private Restaurante restaurante;

    public Sucursal(String direccion, Ciudad ciudad, Restaurante restaurante) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.restaurante = restaurante;
    }

    public String getDireccion() {
        return direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
}