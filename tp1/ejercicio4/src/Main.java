import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear minerales
        Mineral fosforo = new Mineral("Fósforo", true);
        Mineral potasio = new Mineral("Potasio", false);
        Mineral nitrogeno = new Mineral("Nitrógeno", true);
        Mineral calcio = new Mineral("Calcio", false);

        // Crear lotes
        Lote lote1 = new Lote("Lote 1", Arrays.asList(fosforo, potasio));
        Lote lote2 = new Lote("Lote 2", Arrays.asList(nitrogeno, calcio));
        Lote lote3 = new Lote("Lote 3", Arrays.asList(potasio, calcio));

        // Crear cereales
        Cereal maiz = new Gruesa("Maíz", Arrays.asList("Fósforo", "Potasio"));
        Cereal trigo = new Fina("Trigo", Arrays.asList("Nitrógeno", "Calcio"));
        Cereal alfalfa = new Pastura("Alfalfa", Arrays.asList("Potasio", "Calcio"));

        // Crear cooperativa
        Cooperativa coop = new Cooperativa(
                Arrays.asList(lote1, lote2, lote3),
                Arrays.asList(maiz, trigo, alfalfa)
        );

        // Probar el sistema
        for (Lote lote : coop.getLotes()) {
            Cereal recomendado = coop.aconsejarCereal(lote);
            System.out.println("Para " + lote.getNombre() + " se recomienda sembrar: " +
                    (recomendado != null ? recomendado.getNombre() : "Ninguno"));
        }

        // Sembrar y volver a aconsejar
        lote3.sembrar(alfalfa);
        Cereal recomendado2 = coop.aconsejarCereal(lote3);
        System.out.println("Luego de sembrar pastura en Lote 3, se recomienda: " +
                (recomendado2 != null ? recomendado2.getNombre() : "Ninguno"));
    }
}