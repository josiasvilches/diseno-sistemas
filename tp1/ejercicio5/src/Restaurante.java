import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nombre;
    private List<Sucursal> sucursales;
    private List<Plato> platos;

    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
        this.platos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void agregarSucursal(Sucursal sucursal) {
        if (!sucursales.contains(sucursal)) {
            sucursales.add(sucursal);
        }
    }

    public void agregarPlato(Plato plato) {
        if (platos.size() < 20 && !platos.contains(plato)) {
            platos.add(plato);
        }
    }
}