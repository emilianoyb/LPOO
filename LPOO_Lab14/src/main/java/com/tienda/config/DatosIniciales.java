package com.tienda.config;

import com.tienda.model.Videojuego;
import com.tienda.repository.VideojuegoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

// Si la tabla está vacía, carga algunos juegos de ejemplo
@Component
public class DatosIniciales implements CommandLineRunner {

    private final VideojuegoRepository repo;

    public DatosIniciales(VideojuegoRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() > 0) {
            return;
        }
        repo.saveAll(List.of(
            new Videojuego("The Legend of Zelda: Tears of the Kingdom",
                "Nintendo Switch", "Aventura", "E10+",
                new BigDecimal("1399.00"), 12, 2023),
            new Videojuego("God of War Ragnarök",
                "PlayStation 5", "Acción", "M",
                new BigDecimal("1199.00"), 8, 2022),
            new Videojuego("Halo Infinite",
                "Xbox Series X|S", "Shooter", "M",
                new BigDecimal("999.00"), 4, 2021),
            new Videojuego("EA Sports FC 25",
                "PlayStation 5", "Deportes", "E",
                new BigDecimal("1299.00"), 20, 2024),
            new Videojuego("Elden Ring",
                "PC", "RPG", "M",
                new BigDecimal("899.00"), 0, 2022),
            new Videojuego("Mario Kart 8 Deluxe",
                "Nintendo Switch", "Carreras", "E",
                new BigDecimal("1199.00"), 15, 2017),
            new Videojuego("Hogwarts Legacy",
                "PlayStation 4", "RPG", "T",
                new BigDecimal("699.00"), 3, 2023),
            new Videojuego("Cyberpunk 2077",
                "Xbox One", "RPG", "M",
                new BigDecimal("599.00"), 6, 2020)
        ));
    }
}
