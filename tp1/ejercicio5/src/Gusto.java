public class Gusto {
    private Persona persona;
    private PlatoServido platoServido;

    public Gusto(Persona persona, PlatoServido platoServido) {
        this.persona = persona;
        this.platoServido = platoServido;
    }

    public Persona getPersona() {
        return persona;
    }

    public PlatoServido getPlatoServido() {
        return platoServido;
    }
}