public class Guerrero extends Personaje {

    private String arma;
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida,
                    String arma, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.fuerza = fuerza;
    }

    public String getArma() { return arma; }
    public int getFuerza()  { return fuerza; }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] golpea con " +
                           arma + ". Daño: " +
                           calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return fuerza + nivel * 5;
    }
}