package com.tienda.repository;

import com.tienda.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideojuegoRepository
        extends JpaRepository<Videojuego, Long> {

    // Busca por título o género y, si plataforma no está vacía,
    // filtra también por plataforma.
    @Query("SELECT v FROM Videojuego v " +
           "WHERE (LOWER(v.titulo) LIKE LOWER(CONCAT('%', :q, '%')) " +
           "   OR LOWER(v.genero) LIKE LOWER(CONCAT('%', :q, '%'))) " +
           "AND (:plataforma = '' OR v.plataforma = :plataforma) " +
           "ORDER BY v.titulo")
    List<Videojuego> buscar(@Param("q") String q,
                            @Param("plataforma") String plataforma);
}
