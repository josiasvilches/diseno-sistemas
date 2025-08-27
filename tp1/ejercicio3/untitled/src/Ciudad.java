import java.util.List;

public class Ciudad {
    private String nombre;
    private int habitantes;
    private List<Impuesto> impuestos;
    private int gastoMantenimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    public int getGastoMantenimiento() {
        return gastoMantenimiento;
    }

    public void setGastoMantenimiento(int gastoMantenimiento) {
        this.gastoMantenimiento = gastoMantenimiento;
    }

    public Ciudad(String nombre, int habitantes, List<Impuesto> impuestos, int gastoMantenimiento) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.impuestos = impuestos;
        this.gastoMantenimiento = gastoMantenimiento;
    }

    public int recaudacion_total(){
        int recaudacion = 0;
        for(int i = 0; i < this.impuestos.size(); i++){
            recaudacion += impuestos.get(i).getMonto();
        }
        return recaudacion;
    }

    public boolean esta_en_deficit(){
        if (this.recaudacion_total() > this.gastoMantenimiento){
            return false;
        } else {
            return true;
        }
    }
}
