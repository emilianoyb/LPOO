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
    public void atacar() {
        almasAbsorbidas++;
        System.out.println("[" + nombre +
                           "] drena la esencia vital." +
                           " Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return mana + nivel * 10 + almasAbsorbidas * 5;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre +
                           " lanza: ¡Maldición de" +
                           " decadencia! (maná: " + mana + ")");
    }

    @Override
    public int getMana() { return mana; }
}
