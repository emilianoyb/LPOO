public class Bardo extends Personaje implements Sanador {

    private int poderCuracion;
    private String instrumento;
    private int carisma;

    public Bardo(String nombre, int nivel, int puntosVida,
                  int poderCuracion, String instrumento, int carisma) {
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.instrumento = instrumento;
        this.carisma = carisma;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public int getCarisma() {
        return carisma;
    }

    @Override
    public int calcularDanio() {
        return carisma * nivel * 2;
    }

    @Override
    public void atacar() {
        int danio = calcularDanio();
        System.out.println("[" + nombre + "] aturde con un acorde disonante de su " + instrumento +
                ", causando " + danio + " de daño.");
    }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " entona una melodía curativa y cura a " + aliado.getNombre() +
                " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    @Override
    public String toString() {
        return super.toString() + " | Poder Curación: " + poderCuracion +
                " | Instrumento: " + instrumento + " | Carisma: " + carisma;
    }
}
