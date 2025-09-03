import java.util.List;
import java.util.ArrayList;


public class Estacion_de_esqui {
    private String nombre;
    private int codigo;
    private List<Esquiador>  personas_contacto = new ArrayList<>();
    private String direccion;
    private int telefono;
    private int k_esquiables;
    private int n_pistas;
    private List<Pista> pistas = new ArrayList<>();
    private List<Federacion> federaciones = new ArrayList<>();
}
