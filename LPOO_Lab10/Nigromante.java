public class Nigromante extends Personaje
                        implements Hechicero {

    private int mana;
    private int almasAbsorbidas;

    public Nigromante(String nombre, int nivel,
                      int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = 0;
    }

    @Override
    public void atacar() throws RpgException {

        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (mana < 15) {
            throw new RecursoInsuficienteException(
                "mana", mana);
        }

        mana -= 15;
        almasAbsorbidas++;
        System.out.println("[" + nombre +
                           "] drena la esencia vital. " +
                           "Almas: " + almasAbsorbidas);
    }

    @Override
    public int calcularDanio() {
        return mana + nivel * 10 + almasAbsorbidas * 5;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre +
                           " lanza: ¡Maldición de" +
                           " decadencia! (maná: " +
                           mana + ")");
    }

    @Override
    public int getMana() { return mana; }
}
