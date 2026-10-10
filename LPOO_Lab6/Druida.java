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

    public String getVinculoAnimal() {
        return vinculoAnimal;
    }

    @Override
    public int calcularDanio() {
        return mana + poderCuracion;
    }

    @Override
    public void atacar() {
        int danio = calcularDanio();
        System.out.println("[" + nombre + "] invoca raíces del bosque, causando " + danio + " de daño.");
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza un hechizo de naturaleza: ¡Enredadera Venenosa! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " canaliza a " + vinculoAnimal + " y cura a " + aliado.getNombre() +
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
