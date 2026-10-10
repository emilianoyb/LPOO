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
    public void atacar() {
        System.out.println("[" + nombre +
                           "] invoca raíces del bosque." +
                           " Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return mana + nivel * 14;
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
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " cura a " +
                           aliado.getNombre() + " +" +
                           poderCuracion + ". Vida: " +
                           aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() { return poderCuracion; }
}
