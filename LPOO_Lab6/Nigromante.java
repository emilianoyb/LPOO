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

    public int getAlmasAbsorbidas() {
        return almasAbsorbidas;
    }

    public int getNivelOscuridad() {
        return nivelOscuridad;
    }

    @Override
    public int calcularDanio() {
        return mana + (almasAbsorbidas * 10);
    }

    @Override
    public void atacar() {
        int danio = calcularDanio();
        almasAbsorbidas++;
        System.out.println("[" + nombre + "] drena la esencia vital de sus enemigos, causando " + danio + " de daño.");
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " invoca una maldición oscura: ¡Toque de la Muerte! (maná: " + mana + ")");
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
