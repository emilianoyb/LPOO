package com.tienda.model;

import java.util.List;

// Listas fijas que se muestran en los menús desplegables
public final class Catalogos {

    private Catalogos() {}

    public static final List<String> PLATAFORMAS = List.of(
        "PlayStation 5", "PlayStation 4", "Xbox Series X|S",
        "Xbox One", "Nintendo Switch", "PC");

    public static final List<String> GENEROS = List.of(
        "Acción", "Aventura", "RPG", "Shooter", "Deportes",
        "Carreras", "Estrategia", "Simulación", "Terror",
        "Peleas", "Plataformas");

    // Clasificación ESRB
    public static final List<String> CLASIFICACIONES = List.of(
        "E", "E10+", "T", "M");
}
