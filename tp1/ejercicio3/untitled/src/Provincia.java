import java.util.ArrayList;
import java.util.List;

public class Provincia {
    private String nombre;
    private List<Ciudad> ciudades;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Provincia() {
    }

    public Provincia(String nombre, List<Ciudad> ciudades) {
        this.nombre = nombre;
        this.ciudades = ciudades;
    }

    public void agregarCiudad(Ciudad ciudad){
        this.ciudades.add(ciudad);
    }

    public List<Ciudad> ciudadesEnDeficit(){
        List<Ciudad> ciudadesDeficit = new ArrayList<>();
        for (Ciudad ciudad : this.ciudades) {
            if(ciudad.esta_en_deficit()){
                ciudadesDeficit.add(ciudad);
            }
        }
        return ciudadesDeficit;
    }

    public int recaudacion(){
        int recaudacion = 0;
        for (Ciudad ciudad : this.ciudades){
            recaudacion += ciudad.recaudacion_total();
        }
        return recaudacion;
    }

    public int perdidas(){
        int perdidas = 0;
        for (Ciudad ciudad : this.ciudades){
            perdidas += ciudad.getGastoMantenimiento();
        }
        return perdidas;
    }

    public boolean estaEnDeficit(){
        if (this.recaudacion()>this.perdidas()){
            return false;
        } else {
            return true;
        }
    }
}
