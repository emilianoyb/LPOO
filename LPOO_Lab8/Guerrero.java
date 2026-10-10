public class Guerrero extends Personaje {

    private String arma;
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida, String arma, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.fuerza = fuerza;
    }

    public String getArma() {
        return arma;
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public int calcularDanio() {
        return fuerza + nivel * 10;
    }

    @Override
    public void atacar() throws RpgException {

        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        System.out.println("[" + nombre + "] golpea con su " + arma + " con toda su fuerza.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Arma: " + arma + " | Fuerza: " + fuerza;
    }
}
