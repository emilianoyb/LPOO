public class Druida extends Personaje implements Hechicero, Sanador {

    private int mana;
    private int poderCuracion;
    private String vinculoAnimal;

    public Druida(String nombre, int nivel, int puntosVida,
                   int mana, int poderCuracion, String vinculoAnimal) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.vinculoAnimal = vinculoAnimal;
    }

    // Constructor sobrecargado de conveniencia (usado por Main del Lab 08):
    // el poder de curación se deriva del nivel y el vínculo es genérico.
    public Druida(String nombre, int nivel, int puntosVida, int mana) {
        this(nombre, nivel, puntosVida, mana, nivel * 10, "Naturaleza");
    }

    public String getVinculoAnimal() {
        return vinculoAnimal;
    }

    @Override
    public int calcularDanio() {
        return nivel * 20 + poderCuracion;
    }

    @Override
    public void atacar() throws RpgException {

        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }

        mana -= 10;
        System.out.println("[" + nombre + "] invoca raíces del bosque y ataca con furia natural. " +
                           "Maná restante: " + mana);
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Tormenta de espinas! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void curarAliado(Personaje aliado) throws RpgException {

        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }

        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException("curarAliado",
                    "No se puede curar a un personaje derrotado");
        }

        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " toca la tierra y cura a " + aliado.getNombre() +
                           " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    @Override
    public String toString() {
        return super.toString() + " | Maná: " + mana + " | Poder Curación: " + poderCuracion +
               " | Vínculo: " + vinculoAnimal;
    }
}
