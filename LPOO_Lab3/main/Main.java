package main;

import java.util.Scanner;

import vehiculo.Vehiculo;
import automovil.Automovil;
import avion.Avion;
import barco.Barco;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistema de Transporte Multimodal ===\n");

        // ---------------- Automovil ----------------
        System.out.println("-- Registro de Automovil --");
        System.out.print("Marca: ");
        String marcaAuto = sc.nextLine();
        System.out.print("Modelo: ");
        String modeloAuto = sc.nextLine();
        System.out.print("Año: ");
        int anioAuto = Integer.parseInt(sc.nextLine());
        System.out.print("Velocidad máxima (km/h): ");
        double velAuto = Double.parseDouble(sc.nextLine());
        System.out.print("Número de puertas: ");
        int puertasAuto = Integer.parseInt(sc.nextLine());
        System.out.print("¿Es eléctrico? (S/N): ");
        boolean electricoAuto = sc.nextLine().trim().equalsIgnoreCase("S");

        Automovil auto = new Automovil(marcaAuto, modeloAuto, anioAuto, velAuto,
                puertasAuto, electricoAuto);

        // ---------------- Avion ----------------
        System.out.println("\n-- Registro de Avion --");
        System.out.print("Marca: ");
        String marcaAvion = sc.nextLine();
        System.out.print("Modelo: ");
        String modeloAvion = sc.nextLine();
        System.out.print("Año: ");
        int anioAvion = Integer.parseInt(sc.nextLine());
        System.out.print("Velocidad máxima (km/h): ");
        double velAvion = Double.parseDouble(sc.nextLine());
        System.out.print("Número de motores: ");
        int motoresAvion = Integer.parseInt(sc.nextLine());
        System.out.print("Altitud máxima (m): ");
        double altitudAvion = Double.parseDouble(sc.nextLine());
        System.out.print("Aerolínea: ");
        String aerolineaAvion = sc.nextLine();

        Avion avion = new Avion(marcaAvion, modeloAvion, anioAvion, velAvion,
                motoresAvion, altitudAvion, aerolineaAvion);

        // ---------------- Barco ----------------
        System.out.println("\n-- Registro de Barco --");
        System.out.print("Marca: ");
        String marcaBarco = sc.nextLine();
        System.out.print("Modelo: ");
        String modeloBarco = sc.nextLine();
        System.out.print("Año: ");
        int anioBarco = Integer.parseInt(sc.nextLine());
        System.out.print("Velocidad máxima (km/h): ");
        double velBarco = Double.parseDouble(sc.nextLine());
        System.out.print("Tipo de casco: ");
        String cascoBarco = sc.nextLine();
        System.out.print("Tonelaje máximo (t): ");
        double tonelajeBarco = Double.parseDouble(sc.nextLine());
        System.out.print("Número de tripulantes: ");
        int tripulantesBarco = Integer.parseInt(sc.nextLine());

        Barco barco = new Barco(marcaBarco, modeloBarco, anioBarco, velBarco,
                cascoBarco, tonelajeBarco, tripulantesBarco);

        sc.close();

        // ---------------- Resultados ----------------
        System.out.println("\n=== Vehículos registrados ===");

        System.out.println("\n-- Automovil --");
        System.out.println(auto);

        System.out.println("\nProbando validaciones con valores incorrectos:");
        auto.setAnio(1800);        // debe mostrar mensaje de error
        auto.setNumPuertas(10);    // debe mostrar mensaje de error

        System.out.println("\n-- Avion --");
        System.out.println(avion);

        System.out.println("\n-- Barco --");
        System.out.println(barco);

        // ---------------- Demostración de sobrecarga de métodos ----------------
        System.out.println("\n=== Demostración de sobrecarga de métodos ===");

        // describir() sin parámetros vs describir(String) con encabezado
        auto.describir();
        avion.describir("Detalle del vuelo:");

        // setVelocidadMax(double) vs setVelocidadMax(int) -- misma acción, distinto tipo
        barco.setVelocidadMax(50.5);
        barco.setVelocidadMax(55);
        System.out.println("Nueva velocidad máxima del barco: " + barco.getVelocidadMax());

        // Vehiculo(marca, modelo, anio) vs Vehiculo(marca, modelo, anio, velocidadMax)
        Vehiculo generico = new Vehiculo("Genérico", "Prototipo", 2024);
        System.out.println("\nVehículo creado con constructor sobrecargado (sin vel. máx.): " + generico);
    }
}
