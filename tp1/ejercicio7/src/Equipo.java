import java.util.List;
import java.util.ArrayList;

public class Equipo {
    private int codigo;
    private Esquiador entrenador;
    private List<Esquiador> integrantes = new ArrayList<>();

    public int cant_participantes(){
        return this.integrantes.size();
    }
}
