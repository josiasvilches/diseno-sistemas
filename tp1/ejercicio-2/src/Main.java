public class Main {
    public static void main(String[] args) {
        Continente america = new Continente();
        Pais argentina = new Pais();
        Provincia buenosAires = new Provincia();
        Ciudad laPlata = new Ciudad(true);

        buenosAires.agregarCiudad(laPlata);
        argentina.agregarProvincia(buenosAires);
        argentina.agregarCapital(laPlata);
        america.agregarPais(argentina);

    }
}