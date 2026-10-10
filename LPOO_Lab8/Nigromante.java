public class Nigromante extends Personaje implements Hechicero {

    private int mana;
    private int almasAbsorbidas;
    private int nivelOscuridad;

    public Nigromante(String nombre, int nivel, int puntosVida,
                       int mana, int almasAbsorbidas, int nivelOscuridad) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.nivelOscuridad = nivelOscuridad;
    }

    // Constructor sobrecargado de conveniencia (usado por Main del Lab 08):
    // empieza sin almas absorbidas y con nivel de oscuridad 1.
    public Nigromante(String nombre, int nivel, int puntosVida, int mana) {
        this(nombre, nivel, puntosVida, mana, 0, 1);
    }

    public int getAlmasAbsorbidas() {
        return almasAbsorbidas;
    }

    public int getNivelOscuridad() {
        return nivelOscuridad;
    }

    @Override
    public int calcularDanio() {
        return nivel * 25 + almasAbsorbidas * 10;
    }

    @Override
    public void atacar() throws RpgException {

        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (mana < 15) {
            throw new RecursoInsuficienteException("mana", mana);
        }

        mana -= 15;
        almasAbsorbidas++;
        System.out.println("[" + nombre + "] drena la esencia vital de su enemigo. " +
                           "Maná restante: " + mana);
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Maldición de decadencia! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return super.toString() + " | Maná: " + mana + " | Almas Absorbidas: " + almasAbsorbidas +
               " | Nivel Oscuridad: " + nivelOscuridad;
    }
}
