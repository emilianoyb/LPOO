package mago;

import personaje.Personaje;

public class Mago extends Personaje {

    private int poderMagico;
    private String escuelaMagia;

    public Mago(String nombre, int nivel, int puntosVida, int poderMagico, String escuelaMagia) {
        super(nombre, nivel, puntosVida);
        this.poderMagico = poderMagico;
        this.escuelaMagia = escuelaMagia;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public String getEscuelaMagia() {
        return escuelaMagia;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " lanza una bola de fuego causando " + poderMagico + " de maná!");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " invoca un escudo arcano.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Poder Mágico: " + poderMagico + " | Escuela: " + escuelaMagia;
    }
}
