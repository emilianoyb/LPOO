package arquero;

import personaje.Personaje;

public class Arquero extends Personaje {

    private int precision;
    private int flechasDisponibles;

    public Arquero(String nombre, int nivel, int puntosVida, int precision, int flechasDisponibles) {
        super(nombre, nivel, puntosVida);
        this.precision = precision;
        this.flechasDisponibles = flechasDisponibles;
    }

    public int getPrecision() {
        return precision;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    @Override
    public void atacar() {
        System.out.println("[" + getNombre() + "] dispara una flecha con precisión del " + precision + "%.");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " se desplaza ágilmente esquivando el ataque.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Precisión: " + precision + "% | Flechas: " + flechasDisponibles;
    }
}
