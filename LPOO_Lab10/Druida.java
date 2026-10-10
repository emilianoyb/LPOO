public class Druida extends Personaje
                    implements Hechicero, Sanador {

    private int mana;
    private int poderCuracion;
    private String formaNatural;

    public Druida(String nombre, int nivel, int puntosVida,
                  int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = nivel * 12;
        this.formaNatural = "Oso";
    }

    @Override
    public void atacar() throws RpgException {

        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (mana < 10) {
            throw new RecursoInsuficienteException(
                "mana", mana);
        }

        mana -= 10;
        System.out.println("[" + nombre +
                           "] invoca raíces del bosque y " +
                           "ataca con furia natural.");
    }

    @Override
    public int calcularDanio() {
        return mana + nivel * 15;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre +
                           " lanza: ¡Tormenta de espinas!" +
                           " (maná: " + mana + ")");
    }

    @Override
    public int getMana() { return mana; }

    @Override
    public void curarAliado(Personaje aliado)
            throws RpgException {

        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }

        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException("curarAliado",
                "No se puede curar a un personaje derrotado");
        }

        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " cura a " +
                           aliado.getNombre() + " +" +
                           poderCuracion + ". Vida: " +
                           aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() { return poderCuracion; }
}
