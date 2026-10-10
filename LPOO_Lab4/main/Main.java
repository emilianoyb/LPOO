package main;

import personaje.Personaje;
import guerrero.Guerrero;
import mago.Mago;
import arquero.Arquero;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Batalla RPG ===\n");

        Guerrero Luffy = new Guerrero("Luffy", 10, 250, 50, "Cota de Malla");
        Mago Imu = new Mago("Imu", 20, 400, 200, "Fuego");
        Arquero Ussop = new Arquero("Ussop", 4, 95, 95, 30);

        Personaje[] personajes = { Luffy, Imu, Ussop };

        System.out.println("-- Ronda 1: Ataques --");
        for (Personaje p : personajes) {
            p.atacar();
            System.out.println();
        }

        System.out.println("-- Ronda 2: Defensas --");
        for (Personaje p : personajes) {
            p.defender();
        }
        System.out.println();

        System.out.println("-- Daño recibido --");
        personajes[0].recibirDanio(250);
        personajes[1].recibirDanio(200);
        System.out.println();

        System.out.println("-- Estado final --");
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }
}
