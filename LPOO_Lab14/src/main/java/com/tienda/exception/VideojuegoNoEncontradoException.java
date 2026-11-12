package com.tienda.exception;

public class VideojuegoNoEncontradoException extends RuntimeException {

    public VideojuegoNoEncontradoException(Long id) {
        super("No se encontró el videojuego con id " + id);
    }
}
