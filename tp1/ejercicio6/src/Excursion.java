import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String codigo;
    private LocalDate dia;
    private LocalTime hora;
    private List<Visitante> visitantesInscritos;
    private List<Alojamiento> alojamientosOrganizadores;

    public Excursion(String codigo, LocalDate dia, LocalTime hora) {
        this.codigo = codigo;
        this.dia = dia;
        this.hora = hora;
        this.visitantesInscritos = new ArrayList<>();
        this.alojamientosOrganizadores = new ArrayList<>();
    }

    public void addVisitante(Visitante v) { this.visitantesInscritos.add(v); }
    public void addAlojamientoOrganizador(Alojamiento a) { this.alojamientosOrganizadores.add(a); }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public LocalDate getDia() { return dia; }
    public void setDia(LocalDate dia) { this.dia = dia; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
}