package com.tienda.service;

import com.tienda.exception.StockInsuficienteException;
import com.tienda.exception.VideojuegoNoEncontradoException;
import com.tienda.model.ResumenInventario;
import com.tienda.model.Videojuego;
import com.tienda.repository.VideojuegoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VideojuegoService {

    // Con este stock o menos se considera "poco stock"
    public static final int UMBRAL_POCO_STOCK = 5;

    private final VideojuegoRepository repo;

    public VideojuegoService(VideojuegoRepository repo) {
        this.repo = repo;
    }

    public List<Videojuego> listar(String q, String plataforma) {
        String texto = (q == null) ? "" : q.trim();
        String plat = (plataforma == null) ? "" : plataforma.trim();
        return repo.buscar(texto, plat);
    }

    public Videojuego buscarPorId(Long id) {
        return repo.findById(id)
                   .orElseThrow(() ->
                       new VideojuegoNoEncontradoException(id));
    }

    public void guardar(Videojuego videojuego) {
        repo.save(videojuego);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new VideojuegoNoEncontradoException(id);
        }
        repo.deleteById(id);
    }

    // Registra la venta de una unidad: descuenta 1 del stock
    public Videojuego vender(Long id) {
        Videojuego juego = buscarPorId(id);
        if (juego.getStock() <= 0) {
            throw new StockInsuficienteException(juego.getTitulo());
        }
        juego.setStock(juego.getStock() - 1);
        return repo.save(juego);
    }

    // Calcula los totales del inventario para el panel
    public ResumenInventario resumen() {
        List<Videojuego> todos = repo.findAll();

        long unidades = 0;
        long agotados = 0;
        long pocoStock = 0;
        BigDecimal valor = BigDecimal.ZERO;

        for (Videojuego v : todos) {
            int stock = v.getStock();
            unidades += stock;
            valor = valor.add(
                v.getPrecio().multiply(BigDecimal.valueOf(stock)));
            if (stock == 0) {
                agotados++;
            } else if (stock <= UMBRAL_POCO_STOCK) {
                pocoStock++;
            }
        }
        return new ResumenInventario(todos.size(), unidades,
                                     valor, agotados, pocoStock);
    }
}
