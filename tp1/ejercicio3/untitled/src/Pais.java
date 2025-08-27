import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nombre;
    private List<Provincia> provincias;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public Pais() {
    }

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProvincia(Provincia provincia) {
        this.provincias.add(provincia);
    }

    public List<Provincia> provinciasEnDeficit(){
        List<Provincia> provinciasEnDeficit = new ArrayList<>();
        for(Provincia provincia : this.provincias){
            if (provincia.estaEnDeficit()){
                provinciasEnDeficit.add(provincia);
            }
        }
        return (provinciasEnDeficit);
    }
}
