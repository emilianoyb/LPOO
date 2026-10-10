public class Arquero extends Personaje {

    private String arma;
    private int flechas;
    private int precision;

    public Arquero(String nombre, int nivel, int puntosVida,
                   String arma, int flechas, int precision) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.flechas = flechas;
        this.precision = precision;
    }

    public String getArma()   { return arma; }
    public int getFlechas()   { return flechas; }
    public int getPrecision() { return precision; }

    @Override
    public void atacar() {
        if (flechas <= 0) {
            System.out.println("[" + nombre +
                               "] no tiene flechas.");
            return;
        }
        flechas--;
        System.out.println("[" + nombre + "] dispara con " +
                           arma + ". Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return precision + nivel * 4;
    }
}
