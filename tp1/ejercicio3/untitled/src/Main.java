import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pais Argentina = new Pais("Argentina");
        Imp1 imp_renta = new Imp1("Impuesto a la renta", 12000);
        Imp2 imp_iva = new Imp2("Impuesto IVA", 18000);
        Imp3 aportes = new Imp3("Aportes Jubilatorios", 23000);
        List<Impuesto> paquete1 = new ArrayList<Impuesto>();
        List<Impuesto> paquete2 = new ArrayList<Impuesto>();
        List<Impuesto> paquete3 = new ArrayList<Impuesto>();
        paquete1.add(imp_renta);
        paquete1.add(imp_iva);
        paquete1.add(aportes);
        paquete2.add(imp_iva);
        paquete2.add(aportes);
        paquete3.add(imp_iva);
        Ciudad mendoza_ciudad = new Ciudad("Mendoza", 1500000,paquete1,230000000);
        Ciudad san_rafael = new Ciudad("San Rafael", 124, paquete3, 1500000);
        Ciudad la_paz = new Ciudad("La Paz", 50000, paquete2, 1500000);
        List<Ciudad> ciudades_mendoza = new ArrayList<Ciudad>();
        ciudades_mendoza.add(mendoza_ciudad);
        ciudades_mendoza.add(la_paz);
        ciudades_mendoza.add(san_rafael);
        Provincia mendoza = new Provincia("Provincia de Mendoza", ciudades_mendoza)
        Argentina.agregarProvincia(mendoza);

        int i;
        for(i=0,i<=Argentina.provinciasEnDeficit().size(), i++){
            System.out.println(Argentina.provinciasEnDeficit().get(i).getNombre());
        }
    }
}
